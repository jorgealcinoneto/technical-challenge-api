package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;


public interface ProfileRepository extends JpaRepository<Profile, Long> {
	

}
