package com.jorgealcinoneto.technicalchallenge.api.repositories;


import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;
import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;
import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private OfficeRepository  officeRepository;
	
	public Long idUserPersisted;
	
	@Before
	public void setUp() throws Exception {
		Office office = new Office();
		office.setName("Vendedor");
		office.setDescription("vendedor da compania");
		
		this.officeRepository.save(office);
		
		Profile profile = new Profile();
		profile.setName("Usuario");
		profile.setDescription("Usuario comum");
		
		this.profileRepository.save(profile);
		User user = this.userRepository.save(this.getDataUser());
		this.idUserPersisted = user.getId();
	}

	@After
	public final void tearDown() {
		this.userRepository.deleteAll();
		this.officeRepository.deleteAll();
		this.profileRepository.deleteAll();
	}
	
	private User getDataUser() {
		
		Long idOffice = 1L;
		Optional<Office> office = this.officeRepository.findById(idOffice);
		
		Long idProfille = 2L;
		Optional<Profile> profile = this.profileRepository.findById(idProfille);
		
		User user = new User();
		user.setName("Juliana");
		user.setCpf("14141707775");
		user.setBirthDate(LocalDate.of(1989, 1, 15));
		user.setGender(TypeGender.FEMALE);
		user.setStatus(TypeStatus.ENABLED);
		user.setOffice(office.get());
		user.setProfile(profile.get());
		user.setAge();

		return user;
		
	}
	
	@Test
	public void testFindByCpf() {
		String cpf = "14141707775";
		Optional<User> user = this.userRepository.findByCpf(cpf);
		
		assertNotNull(user);
	}
	
	@Test
	public void testSetStatus() {
		Integer rowsAffected = this.userRepository.updateStatus(TypeStatus.DISABLED, this.idUserPersisted);
		
		System.out.println(rowsAffected);
		assertNotNull(rowsAffected);
	}
	

	
}
