package com.onuar.ejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onuar.ejemplo.dto.CountryDto;
import com.onuar.ejemplo.exception.ResourceNotFoundException;
import com.onuar.ejemplo.services.CountryService;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping()
	public List<CountryDto> getCountries() {
		return countryService.getCountries();
	}

	@PostMapping()
	public ResponseEntity<?> postCountrie(@RequestBody CountryDto country) {
		return ResponseEntity.status(HttpStatus.CREATED).body(countryService.saveCountry(country));

	}

	@DeleteMapping("/{countryid}")
	private ResponseEntity<?> deleteCountry(@PathVariable("countryid") int id) {

		try {
			countryService.deleteCountry(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<CountryDto> updateTutorial(@PathVariable("id") Integer id, @RequestBody CountryDto country) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(countryService.update(country, id));
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}