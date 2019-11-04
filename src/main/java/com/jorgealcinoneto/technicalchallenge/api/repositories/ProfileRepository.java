package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;

@Transactional(readOnly = true)
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	

}
