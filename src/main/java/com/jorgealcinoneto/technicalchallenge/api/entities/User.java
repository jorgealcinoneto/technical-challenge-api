package com.jorgealcinoneto.technicalchallenge.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;

@Entity
@Table(name = "tb_usuario")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7219436904211066483L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "usuario_id")
	private Long id;
	
	@Column(name = "usuario_nome", nullable = false, length = 255)
	private String name;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "sexo", nullable = false)
	private TypeGender gender;
	
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate birthDate;
	
	@OneToOne
	@JoinColumn(name="cargo_id", nullable=false)
	private Office office;
	
	@OneToOne 
	@JoinColumn(name="perfil_id", nullable=true)
	private Profile profile;
	
	@Column(name = "data_criacao", nullable = true)
	private Date createDate;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date updateDate;
	
	@Column(name = "status", nullable = false)
	private TypeStatus status;
	
	@Transient
	private Integer age;
	
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

	public TypeGender getGender() {
		return gender;
	}

	public void setGender(TypeGender gender) {
		this.gender = gender;
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

	public TypeStatus getStatus() {
		return status;
	}

	public void setStatus(TypeStatus status) {
		this.status = status;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	public void setAge() {
		
	  LocalDate currentDate = LocalDate.now();
		
      if ((this.birthDate != null) && (currentDate != null)) {
          this.age = Period.between(this.birthDate, currentDate).getYears();
      } else {
    	  this.age = 0;
      }
	}

	public Integer getAge() {
		
		return this.age;
	}

	@PreUpdate
    public void preUpdate() {
		updateDate = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        createDate = atual;
        updateDate = atual;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", cpf=" + cpf + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", office=" + office + ", profile=" + profile + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", status=" + status + ", age=" + age + "]";
	}
    
    
	
}
