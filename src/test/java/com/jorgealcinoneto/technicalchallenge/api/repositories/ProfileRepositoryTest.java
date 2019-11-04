package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileRepositoryTest {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Before
	public void setUp() throws Exception {
		Profile profile = new Profile();
		profile.setName("Adm");
		profile.setDescription("Administrador do Sistema");
		
		this.profileRepository.save(profile);
	}
	
	@After
    public final void tearDown() { 
		this.profileRepository.deleteAll();
	}

	
}
