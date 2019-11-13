package com.casestudy.jatin.chander.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.jatin.chander.model.Credential;


@Repository
public interface CredentialRepository extends CrudRepository<Credential, String> {
	
	// Query being written behind the scenes
	Credential findByUsername(String username);

}

