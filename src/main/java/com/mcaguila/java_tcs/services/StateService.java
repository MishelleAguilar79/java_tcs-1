package com.onuar.ejemplo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onuar.ejemplo.model.State;
import com.onuar.ejemplo.repository.StateRepo;

@Service
public class StateService {
	@Autowired
	private StateRepo stateRepo;
	
	public List<State> getStates()
	{
		return stateRepo.findAll();
	}
	
	public State save(State state) {

		return stateRepo.save(state);
	}
	
	public void delete(int id)
	{
		stateRepo.deleteById(id);
	}

	//updating a record
	public void update(State state, int id)
	{
		
		
		
		stateRepo.save(state);
	}

	public Optional<State> findById(Integer id) {				
		
		return stateRepo.findById(id);
	}
}
