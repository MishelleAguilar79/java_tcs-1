package com.onuar.ejemplo.controller;

import java.util.List;
import java.util.Optional;

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


import com.onuar.ejemplo.model.State;
import com.onuar.ejemplo.services.StateService;

@RestController
@RequestMapping("/api/v1/state")
public class StateController {
	
	@Autowired
	private StateService stateService;

	@GetMapping()
	public List<State> getStates() {
		return stateService.getStates();
	}

	@PostMapping()
	public ResponseEntity<?> postState(@RequestBody State state) {
		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.save(state));

	}
	
	
	@DeleteMapping("/{stateid}")
	private void deleteState(@PathVariable("stateid") int id)
	{
		stateService.delete(id);
	}


	@PutMapping("/{id}")
	public ResponseEntity<State> updateTutorial(@PathVariable("id") Integer id, @RequestBody State state) {
	 Optional<State> tutorialData = stateService.findById(id);
	 if (tutorialData.isPresent()) {
	  State _state = tutorialData.get();
	  _state.setName(state.getName());
	  _state.setCode(state.getCode());
	  return new ResponseEntity<>(stateService.save(_state), HttpStatus.OK);
	 } else {
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	}

}
