package com.jorgealcinoneto.technicalchallenge.api.services;

import java.util.List;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;



public interface ProfileService {


	public Profile update(Profile profile);
	
	public List<Profile> findAll();
	
}
