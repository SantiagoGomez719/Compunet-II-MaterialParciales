package com.compunet.springboot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.compunet.springboot.model.Club;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long>, PagingAndSortingRepository<Club, Long> {

    // Q4: clubes (sin duplicados) de los jugadores cuyas selecciones están en la lista de países, ordenados por fecha de fundación
    List<Club> findDistinctByPlayerClubs_Player_Country_IdInOrderByFoundedAsc(Collection<Long> countryIds);

}
