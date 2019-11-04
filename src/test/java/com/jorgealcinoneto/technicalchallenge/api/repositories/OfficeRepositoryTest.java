package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class OfficeRepositoryTest {
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Before
	public void setUp() throws Exception {
		Office office = new Office();
		office.setName("Vendedor");
		office.setDescription("Vendedor da compania");
		
		this.officeRepository.save(office);
	}
	
	@After
    public final void tearDown() { 
		this.officeRepository.deleteAll();
	}

	
}
