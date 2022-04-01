package com.onuar.ejemplo.services;

import java.util.List;
import java.util.Optional;

import com.onuar.ejemplo.dto.CountryDto;
import com.onuar.ejemplo.exception.ResourceNotFoundException;

public interface CountryService {

	public List<CountryDto> getCountries();

	public CountryDto saveCountry(CountryDto country);

	public CountryDto update(CountryDto country, int id) throws ResourceNotFoundException;

	public void deleteCountry(int id) throws ResourceNotFoundException;

	public Optional<CountryDto> findCountry(Integer id);
}