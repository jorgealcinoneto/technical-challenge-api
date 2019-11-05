package com.jorgealcinoneto.technicalchallenge.api.vo;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;



public class UserVO {
	
	private Long id;
	
	@NotEmpty(message = "Name is null")
	@Length(min = 3, max = 200, message = "Name must contain between 3 and 255 characters.")
	private String name;
	
	@NotEmpty(message = "CPF is null.")
	@CPF(message="Invalid CPF")
	private String cpf;
	
	@NotEmpty(message = "Gender is null.")
	private String gender;
	
	@NotEmpty(message = "birth Date is null.")
	private String birthDate;
	
	private Long officeId;
	private Long profileId;
	private Integer status;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", cpf=" + cpf + ", gender=" + gender + ", birthDate="
				+ birthDate + ", officeId=" + officeId + ", profileId=" + profileId + ", status=" + status + "]";
	}
	
	



	
	

}
