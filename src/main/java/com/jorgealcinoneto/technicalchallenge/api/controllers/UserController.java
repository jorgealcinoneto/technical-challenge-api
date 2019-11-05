package com.jorgealcinoneto.technicalchallenge.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

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
import com.jorgealcinoneto.technicalchallenge.api.entities.Office;
import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;
import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.response.Response;
import com.jorgealcinoneto.technicalchallenge.api.services.OfficeService;
import com.jorgealcinoneto.technicalchallenge.api.services.ProfileService;
import com.jorgealcinoneto.technicalchallenge.api.services.UserService;
import com.jorgealcinoneto.technicalchallenge.api.vo.UserVO;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("api/user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<UserVO>> create(@Valid @RequestBody UserVO userVO,
			BindingResult result) throws NoSuchAlgorithmException {
		log.info("Creating User: {}", userVO.toString());
		Response<UserVO> response = new Response<UserVO>();

		if (result.hasErrors()) {
			log.error("Validating user data: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		User user = this.getDataUser(userVO);
		User userPersisted = this.userService.persist(user);
		UserVO userVOConverted = this.converterUserToVO(userPersisted);
		
		response.setData(userVOConverted);
		return ResponseEntity.ok(response);
	}
	
	private UserVO converterUserToVO(User user)
			throws NoSuchAlgorithmException {
		UserVO userVO = new UserVO();
		userVO.setId(user.getId());
		userVO.setName(user.getName());
		userVO.setCpf(user.getCpf());
		userVO.setBirthDate(user.getBirthDate().toString());
		userVO.setGender(user.getGender().toString());
		userVO.setOfficeId(user.getOffice().getId());
		userVO.setProfileId(user.getProfile().getId());
		userVO.setStatus(user.getStatus().getValue());
		return userVO;
	}
	
	private User getDataUser(UserVO userVO) {
		
		Optional<Office> office = this.officeService.findById(userVO.getOfficeId());
		
		Optional<Profile> profile = this.profileService.findById(userVO.getProfileId());
		
		User user = new User();
		user.setName(userVO.getName());;
		user.setCpf(userVO.getCpf());
		user.setBirthDate(LocalDate.parse(userVO.getBirthDate()));
		if(userVO.getGender() == "MALE") {
			user.setGender(TypeGender.MALE);
		} else {
			user.setGender(TypeGender.FEMALE);
		}
		user.setOffice(office.get());
		user.setProfile(profile.get());

		return user;
		
	}

	

}
