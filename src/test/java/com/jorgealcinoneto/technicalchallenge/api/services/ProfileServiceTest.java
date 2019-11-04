package com.jorgealcinoneto.technicalchallenge.api.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProfileServiceTest {
	
	@Autowired
	private ProfileService profileService;
	
	@Test
	public void testPersist() {
		
		Profile profile = new Profile();
		
		profile.setName("Operador");
		profile.setDescription("Operador do sistema");
		
		Profile profilePersisted = this.profileService.persist(profile);
		
		assertNotNull(profilePersisted);
	}
}
