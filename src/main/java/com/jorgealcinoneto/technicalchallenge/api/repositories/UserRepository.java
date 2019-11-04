package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;


public interface UserRepository extends JpaRepository<Profile, Long> {
	

}
