package com.onuar.ejemplo.dto;

import com.onuar.ejemplo.model.Country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

	private Integer id;
	private String name;
	private String code;
	
	public Country toEntity() {
		return new Country(id,name,code);
	}
}
