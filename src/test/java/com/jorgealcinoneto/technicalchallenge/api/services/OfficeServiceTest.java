package com.jorgealcinoneto.technicalchallenge.api.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class OfficeServiceTest {
	
	@Autowired
	private OfficeService officeService;
	
	@Test
	public void testPersist() {
		
		Office office = new Office();
		
		office.setName("Analista Fiscal");
		office.setDescription("Analista Fiscal da Cia");
		
		Office officePersisted = this.officeService.persist(office);
		
		assertNotNull(officePersisted);
	}

}
