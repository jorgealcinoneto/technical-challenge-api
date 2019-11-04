package com.jorgealcinoneto.technicalchallenge.api.services;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;

public interface ProfileService {

	/**
	 * Persist a new profile.
	 * 
	 * @param profile
	 * @return Profile
	 */
	public Profile persist(Profile profile);
	
	
}
