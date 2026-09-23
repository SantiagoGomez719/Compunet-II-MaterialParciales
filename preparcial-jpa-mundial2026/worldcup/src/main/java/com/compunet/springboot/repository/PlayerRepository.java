package com.compunet.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.compunet.springboot.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>, PagingAndSortingRepository<Player, Long> {

    // Q1: jugadores que han jugado históricamente en un club (por nombre), orden DESC por nombre del club, solo los primeros 8
    List<Player> findTop8ByPlayerClubs_Club_NameOrderByPlayerClubs_Club_NameDesc(String clubName);

    // Q2: jugadores de un país que han jugado en un club, ordenados por código del país, solo los primeros 5
    List<Player> findTop5ByCountry_NameAndPlayerClubs_Club_NameOrderByCountry_CodeAsc(String countryName, String clubName);

    // Q5: todos los jugadores del mejor al peor FIFA score (el Top 15 de países se arma en el controller)
    List<Player> findAllByOrderByFifaScoreDesc();

}
