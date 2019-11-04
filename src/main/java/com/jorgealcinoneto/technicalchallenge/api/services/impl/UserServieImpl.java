package com.jorgealcinoneto.technicalchallenge.api.services.impl;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;
import com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories.UserJdbcRepository;
import com.jorgealcinoneto.technicalchallenge.api.repositories.UserRepository;
import com.jorgealcinoneto.technicalchallenge.api.services.UserService;

public class UserServieImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServieImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserJdbcRepository userJdbcRepository;

	@Override
	public User persist(User user) {
		log.info("Persisting User: {}", user);
		return this.userRepository.save(user);
	}

	@Override
	public void disable(TypeStatus typeStatus, Long id) {
		log.info("Disabling UserId: {}", id);
		this.userJdbcRepository.updateStatus(typeStatus, id);
	}


	@Override
	public void remove(Long id) {
		log.info("Removing UserId: {}", id);
		this.userRepository.deleteById(id);
	}

}
