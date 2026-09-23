package com.compunet.springboot.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.compunet.springboot.model.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long>, PagingAndSortingRepository<Match, Long> {

    // Q3: partidos como LOCAL de un país (por nombre) cuyos jugadores pertenecen ACTUALMENTE (end_date null) a un club (por nombre)
    List<Match> findDistinctByHomeCountry_NameAndHomeCountry_Players_PlayerClubs_Club_NameAndHomeCountry_Players_PlayerClubs_EndDateIsNullOrderByIdAsc(
        String countryName,
        String clubName
    );

    // Apoyo Q4: partido por id y fecha
    Optional<Match> findByIdAndMatchDate(Long id, LocalDate matchDate);

}
