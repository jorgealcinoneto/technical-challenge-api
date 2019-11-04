package com.jorgealcinoneto.technicalchallenge.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_perfil")
public class Profile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -474484886191810018L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String name;
	
	@Column(name = "descricao", nullable = false, length = 255)
	private String description;

	@Column(name = "data_criacao", nullable = false)
	private Date dateCreate;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dateUpdate;
	
	
	public Profile() {
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

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		return "Profile [id=" + id + ", name=" + name + ", description=" + description + ", dateCreate=" + dateCreate
				+ ", dateUpdate=" + dateUpdate + "]";
	}

	
	
}
