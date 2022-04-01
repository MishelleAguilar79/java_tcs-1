package com.onuar.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onuar.ejemplo.model.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

}