package com.jorgealcinoneto.technicalchallenge.api.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories.UserJdbcRepository;

@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "UserRepository.findByProfileId", 
			query = "SELECT user FROM User user WHERE user.profile.id = :profileId"),
	@NamedQuery(name = "UserRepository.findByOfficeId", 
	query = "SELECT user FROM User user WHERE user.office.id = :officeId")
	
})

public interface UserRepository extends JpaRepository<User, Long>, UserJdbcRepository {
	
	List<User> findByProfileId(@Param("profileId") Long findByProfileId);
	
	List<User> findByOfficeId(@Param("officeId") Long officeId);
	
	public Optional<User> findByName(String name);
	
	public Optional<User> findByCpf(String cpf);
	
	public Optional<User> findByGender(TypeGender typeGender);
	
	
	
}
