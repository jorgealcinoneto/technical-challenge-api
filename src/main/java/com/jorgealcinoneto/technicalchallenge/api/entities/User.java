package com.jorgealcinoneto.technicalchallenge.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7219436904211066483L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String name;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "sexo", nullable = false)
	private String sexo;
	
	@Column(name = "data_nascimento", nullable = false)
	private Date dateOfBirth;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cargo_id", nullable=false)
	private Office office;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="perfil_id", nullable=false)
	private Profile profile;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dateCreate;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dateUpdate;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	public User() {
	}

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@PreUpdate
    public void preUpdate() {
		dateUpdate = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dateCreate = atual;
        dateUpdate = atual;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", cpf=" + cpf + ", sexo=" + sexo + ", dateOfBirth=" + dateOfBirth
				+ ", office=" + office + ", profile=" + profile + ", dateCreate=" + dateCreate + ", dateUpdate="
				+ dateUpdate + ", status=" + status + "]";
	}
	
	

	
}
