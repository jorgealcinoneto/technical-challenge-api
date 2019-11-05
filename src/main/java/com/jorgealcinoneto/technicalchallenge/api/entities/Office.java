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
@Table(name = "tb_cargo")
public class Office implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8251968871829865038L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cargo_id")
	private Long id;
	
	@Column(name = "cargo_nome", nullable = false,length = 100)
	private String name;
	
	@Column(name = "cargo_descricao", nullable = false, length = 255)
	private String description;

	@Column(name = "cargo_data_criacao", nullable = true)
	private Date dateCreate;
	
	@Column(name = "cargo_data_atualizacao", nullable = true)
	private Date dateUpdate;
	
	
	public Office() {
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
