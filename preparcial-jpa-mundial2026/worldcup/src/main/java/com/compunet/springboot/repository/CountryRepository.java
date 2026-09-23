package com.compunet.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.compunet.springboot.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>, PagingAndSortingRepository<Country, Long> {

}
