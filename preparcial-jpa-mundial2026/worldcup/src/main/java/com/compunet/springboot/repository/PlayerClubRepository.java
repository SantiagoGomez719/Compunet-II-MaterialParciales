package com.compunet.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.compunet.springboot.model.PlayerClub;
import com.compunet.springboot.model.PlayerClubId;

@Repository
public interface PlayerClubRepository extends CrudRepository<PlayerClub, PlayerClubId>, PagingAndSortingRepository<PlayerClub, PlayerClubId> {

}
