package com.jorgealcinoneto.technicalchallenge.api.controllers;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgealcinoneto.technicalchallenge.api.converter.DozerConverter;
import com.jorgealcinoneto.technicalchallenge.api.entities.Office;
import com.jorgealcinoneto.technicalchallenge.api.response.Response;
import com.jorgealcinoneto.technicalchallenge.api.services.OfficeService;
import com.jorgealcinoneto.technicalchallenge.api.vo.OfficeVO;

@RestController
@CrossOrigin(origins = "*")
public class OfficeController {
	
	private static final Logger log = LoggerFactory.getLogger(OfficeController.class);
	
	@Autowired
	private OfficeService officeService;
	
	
	/**
	 * Persist a new Office
	 * 
	 * @param officeVO
	 * @param result
	 * @return ResponseEntity<Response<officeVO>>
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("api/office")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<OfficeVO>> cadastrar(@RequestBody OfficeVO officeVO,
			BindingResult result) throws NoSuchAlgorithmException {
		
		log.info("Persisting a new Profile: {}", officeVO.toString());
		Response<OfficeVO> response = new Response<OfficeVO>();
		
		Office office = DozerConverter.parseObject(officeVO, Office.class);
		Office officePersisted = this.officeService.persist(office);
		OfficeVO officeVOConverted = DozerConverter.parseObject(officePersisted, OfficeVO.class);

		response.setData(officeVOConverted);
		return ResponseEntity.ok(response);
		 
	 }
	

}
