package com.compunet.springboot.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.compunet.springboot.model.Match;
import com.compunet.springboot.model.Player;
import com.compunet.springboot.repository.ClubRepository;
import com.compunet.springboot.repository.MatchRepository;
import com.compunet.springboot.repository.PlayerRepository;

@RestController
@RequestMapping("/partial2jap")
public class Partial2Controller {

    private final PlayerRepository playerRepo;
    private final ClubRepository clubRepo;
    private final MatchRepository matchRepo;

    @Autowired
    public Partial2Controller(PlayerRepository playerRepo, ClubRepository clubRepo, MatchRepository matchRepo) {
        this.playerRepo = playerRepo;
        this.clubRepo = clubRepo;
        this.matchRepo = matchRepo;
    }

    // http://localhost:8081/springboot-api/partial2jap/q1?club=Real Madrid
    // Q1: GET /partial2jap/q1?club=Real Madrid
    @GetMapping("/q1")
    public List<String> partial2japQ1PlayersByClub(@RequestParam String club) {
        return playerRepo.findTop8ByPlayerClubs_Club_NameOrderByPlayerClubs_Club_NameDesc(club)
                .stream().map(Player::getName).toList();
    }

    // Q2: GET /partial2jap/q2?country=Colombia&club=Bayern Munich
    @GetMapping("/q2")
    public List<String> partial2japQ2PlayersByCountryAndClub(@RequestParam String country, @RequestParam String club) {
        return playerRepo.findTop5ByCountry_NameAndPlayerClubs_Club_NameOrderByCountry_CodeAsc(country, club)
                .stream().map(Player::getName).toList();
    }

    // Q3: GET /partial2jap/q3?club=Bayern Munich&country=Colombia
    @GetMapping("/q3")
    public List<String> partial2japQ3HomeMatchesByCurrentClub(@RequestParam String club, @RequestParam String country) {
        return matchRepo
                .findDistinctByHomeCountry_NameAndHomeCountry_Players_PlayerClubs_Club_NameAndHomeCountry_Players_PlayerClubs_EndDateIsNullOrderByIdAsc(country, club)
                .stream()
                .map(m -> m.getHomeCountry().getCode() + " vs " + m.getAwayCountry().getCode())
                .toList();
    }

    // Q4: GET /partial2jap/q4?matchId=70&date=2026-06-27   (date es opcional)
    @GetMapping("/q4")
    public List<String> partial2japQ4ClubsByMatch(@RequestParam Long matchId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        Match match = (date == null ? matchRepo.findById(matchId) : matchRepo.findByIdAndMatchDate(matchId, date))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partido no encontrado"));

        List<Long> countryIds = List.of(match.getHomeCountry().getId(), match.getAwayCountry().getId());
        return clubRepo.findDistinctByPlayerClubs_Player_Country_IdInOrderByFoundedAsc(countryIds)
                .stream().map(c -> c.getName()).toList();
    }

    // Q5 (opcional): GET /partial2jap/q5  -> el "max por país" no se puede expresar solo con Query Methods,
    // así que se ordenan los jugadores por score y se queda con la primera aparición de cada país.
    @GetMapping("/q5")
    public List<String> partial2japQ5TopCountries() {
        Map<String, Integer> bestByCountry = new LinkedHashMap<>();
        for (Player p : playerRepo.findAllByOrderByFifaScoreDesc()) {
            bestByCountry.putIfAbsent(p.getCountry().getName(), p.getFifaScore());
        }
        return bestByCountry.keySet().stream().limit(15).toList();
    }

}
