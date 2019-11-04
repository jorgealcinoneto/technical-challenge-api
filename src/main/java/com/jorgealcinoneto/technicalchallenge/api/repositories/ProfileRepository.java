package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;


public interface ProfileRepository extends JpaRepository<User, Long> {
	

}
