package com.jorgealcinoneto.technicalchallenge.api.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;
import com.jorgealcinoneto.technicalchallenge.api.repositories.ProfileRepository;
import com.jorgealcinoneto.technicalchallenge.api.services.ProfileService;


public class ProfileServiceImpl implements ProfileService{
	
	private static final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile update(Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
