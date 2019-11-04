package com.jorgealcinoneto.technicalchallenge.api.dto;

import java.util.Optional;


public class UserDTO {
	
	private Long id;
	private String name;
	private String cpf;
	private String gender;
	private String birthDate;
	private Long officeId;
	private Long profileId;
	private String status;
	private Optional<String> senha = Optional.empty();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Long getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public Long getProfileId() {
		return profileId;
	}
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Optional<String> getSenha() {
		return senha;
	}
	public void setSenha(Optional<String> senha) {
		this.senha = senha;
	}
	
	
	
	

}
