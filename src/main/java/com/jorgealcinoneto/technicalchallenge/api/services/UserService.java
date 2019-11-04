package com.jorgealcinoneto.technicalchallenge.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;

@Service
public interface UserService {

	public User persist(User user);
	
	public void disable(TypeStatus typeStatus, Long id);
	
	public void remove(Long id);
	
	public List<User> listAll(Long id);
	
	
	
	
}
