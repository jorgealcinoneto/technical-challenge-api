package com.jorgealcinoneto.technicalchallenge.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;
import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;
import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;
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
	
	@GetMapping(value = "/api/user/cpf{cpf}")
	public ResponseEntity<Response<String>> getByCpf(@PathVariable("cpf") String cpf) {
		log.info("Find User by CPF: {}", cpf);
		Response<String> response = new Response<String>();
		Optional<User> user = this.userService.findByCpf(cpf);

		if (!user.isPresent()) {
			log.info("User not found: {}", cpf);
			response.getErrors().add("cpf user  not found: " + cpf);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(user.get().toString());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/api/user/")
	public ResponseEntity<Response<String>> getAll() {
		log.info("Find Users : {}");
		Response<String> response = new Response<String>();
		List<User> users = this.userService.listAll();

		response.setData(users.toString());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/api/user/office/{officeId}")
	public ResponseEntity<Response<String>> findByOfficeId(@PathVariable("officeId") Long officeId) {
		log.info("Find Users by OfficeId: {}", officeId);
		Response<String> response = new Response<String>();
		List<User> users = this.userService.findByOfficeId(officeId);

		response.setData(users.toString());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "/api/user/profile/{profileId}")
	public ResponseEntity<Response<String>> findByProfileId(@PathVariable("profileId") Long profileId) {
		log.info("Find Users by OfficeId: {}", profileId);
		Response<String> response = new Response<String>();
		List<User> users = this.userService.findByProfileId(profileId);

		response.setData(users.toString());
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/api/user/{id}")
	public ResponseEntity<Response<String>> disableUser(@PathVariable("id") Long id) {
		log.info("Disable User: {}", id);
		Response<String> response = new Response<String>();

		this.userService.disable(TypeStatus.DISABLED, id);

		response.setData("User disabled Success");

		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/api/user/{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") Long id) {
		log.info("Disable User: {}", id);
		Response<String> response = new Response<String>();

		this.userService.remove(id);

		response.setData("User removed Success");

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
