package com.onuar.ejemplo.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {

	private Integer id;
	private String name;
	private String code;
	private CountryDto country;
	
}