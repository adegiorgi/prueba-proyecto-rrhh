package com.mobydigitalrrhh.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobydigitalrrhh.models.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findById(Integer id);

}
