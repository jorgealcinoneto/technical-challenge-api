package com.jorgealcinoneto.technicalchallenge.api.services;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;

public interface UserService {

	public User create(User user);
	
	public User update(User user);
	
	public void setStatus(TypeStatus typeStatus, Long id);
	
}
