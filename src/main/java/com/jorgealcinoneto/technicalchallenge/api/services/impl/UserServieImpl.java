package com.jorgealcinoneto.technicalchallenge.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;
import com.jorgealcinoneto.technicalchallenge.api.repositories.UserRepository;
import com.jorgealcinoneto.technicalchallenge.api.services.UserService;


public class UserServieImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServieImpl.class);
	
//	@Autowired
//	private UserRepository userRepository;

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatus(TypeStatus typeStatus, Long id) {
		// TODO Auto-generated method stub
		
	}

}
