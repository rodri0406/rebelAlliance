package com.rebel.alliance.app.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rebel.alliance.app.entities.Satellite;

public interface ISatelliteDao extends CrudRepository<Satellite, Long>{

	
	Optional<Satellite> findByName(String name);
}
