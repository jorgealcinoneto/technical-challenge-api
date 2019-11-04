package com.jorgealcinoneto.technicalchallenge.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;
import com.jorgealcinoneto.technicalchallenge.api.repositories.ProfileRepository;
import com.jorgealcinoneto.technicalchallenge.api.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	private static final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile persist(Profile profile) {
		log.info("Persisting Profile: {}", profile);
		return this.profileRepository.save(profile);
	}



}
