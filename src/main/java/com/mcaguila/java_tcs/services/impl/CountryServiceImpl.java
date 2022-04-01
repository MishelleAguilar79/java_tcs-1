package com.onuar.ejemplo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onuar.ejemplo.dto.CountryDto;
import com.onuar.ejemplo.exception.ResourceNotFoundException;
import com.onuar.ejemplo.model.Country;
import com.onuar.ejemplo.repository.CountryRepo;
import com.onuar.ejemplo.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepo countryRepo;

	public List<CountryDto> getCountries() {
		
		List<Country> objCountry =countryRepo.findAll();
		
		return objCountry.stream().map(c -> c.ToDto()).collect(Collectors.toList());
				
	}

	public CountryDto saveCountry(CountryDto country) {

		return countryRepo.save(country.toEntity()).ToDto();
	}

	public CountryDto update(CountryDto country, int id) throws ResourceNotFoundException {
		Optional<CountryDto> tutorialData = findCountry(id);
		if (tutorialData.isPresent()) {
			Country objCountry = tutorialData.get().toEntity();
			objCountry.setName(country.getName());
			objCountry.setCode(country.getCode());
			return countryRepo.save(objCountry).ToDto();
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}

	}

	public void deleteCountry(int id) throws ResourceNotFoundException {
		Optional<CountryDto> tutorialData = findCountry(id);
		if (tutorialData.isPresent()) {
			countryRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}

	public Optional<CountryDto> findCountry(Integer id) {
		
		Optional<Country>  objCountry = countryRepo.findById(id);
		Optional<CountryDto> objCountryDto;
		if(objCountry.isPresent()) {
			
			objCountryDto =  Optional.of(objCountry.get().ToDto());
		}
		else {
			objCountryDto = Optional.empty();
		}	
		return objCountryDto;
	}
}
