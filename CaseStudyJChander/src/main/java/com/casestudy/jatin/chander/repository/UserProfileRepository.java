package com.casestudy.jatin.chander.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.jatin.chander.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	
	UserProfile findByFirstname(String name);

}
