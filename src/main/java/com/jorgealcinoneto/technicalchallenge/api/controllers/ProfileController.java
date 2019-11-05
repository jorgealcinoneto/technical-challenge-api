package com.jorgealcinoneto.technicalchallenge.api.controllers;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgealcinoneto.technicalchallenge.api.converter.DozerConverter;
import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;
import com.jorgealcinoneto.technicalchallenge.api.response.Response;
import com.jorgealcinoneto.technicalchallenge.api.services.ProfileService;
import com.jorgealcinoneto.technicalchallenge.api.vo.ProfileVO;

@RestController
@CrossOrigin(origins = "*")
public class ProfileController {
	
	private static final Logger log = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService profileService;
	
	
	/**
	 * Persist a new Profile
	 * 
	 * @param profileVO
	 * @param result
	 * @return ResponseEntity<Response<profileVO>>
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("api/profile")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<ProfileVO>> cadastrar(@RequestBody ProfileVO profileVO,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Persisting a new Profile: {}", profileVO.toString());
		Response<ProfileVO> response = new Response<ProfileVO>();
		
		Profile profile = DozerConverter.parseObject(profileVO, Profile.class);
		Profile profilePersisted = this.profileService.persist(profile);
		ProfileVO profileVOConverted = DozerConverter.parseObject(profilePersisted, ProfileVO.class);

		response.setData(profileVOConverted);
		return ResponseEntity.ok(response);
		 
	 }
	

}
