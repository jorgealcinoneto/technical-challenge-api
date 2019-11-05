package com.jorgealcinoneto.technicalchallenge.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;
import com.jorgealcinoneto.technicalchallenge.api.repositories.UserRepository;
import com.jorgealcinoneto.technicalchallenge.api.services.UserService;

@Service
public class UserServieImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServieImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User persist(User user) {
		log.info("Persisting User: {}", user);
		return this.userRepository.save(user);
	}

	@Override
	public void disable(TypeStatus typeStatus, Long id) {
		log.info("Disabling UserId: {}", id);
		this.userRepository.updateStatus(typeStatus, id);
	}


	@Override
	public void remove(Long id) {
		log.info("Removing UserId: {}", id);
		this.userRepository.deleteById(id);
	}

	@Override
	public List<User> listAll() {
		return this.userRepository.findAll();
	}

	@Override
	public List<User> findByProfileId(Long findByProfileId) {
		return this.userRepository.findByProfileId(findByProfileId);
	}

	@Override
	public List<User> findByOfficeId(Long officeId) {
		// TODO Auto-generated method stub
		return this.userRepository.findByOfficeId(officeId);
	}

	@Override
	public Optional<User> findByName(String name) {
		// TODO Auto-generated method stub
		return this.userRepository.findByName(name);
	}

	@Override
	public Optional<User> findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return this.userRepository.findByCpf(cpf);
	}


	
	
	
	

}
