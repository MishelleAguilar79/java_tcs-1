

package com.onuar.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onuar.ejemplo.model.Country;
import com.onuar.ejemplo.model.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {

}

