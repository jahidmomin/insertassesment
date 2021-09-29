package com.backendlms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backendlms.model.Assesment;
import com.backendlms.model.NewAssesment;
import com.backendlms.service.IUploadService;

@RestController
public class UploadAssesmentNew {
	
	@Autowired
	private IUploadService service;
	
	@PostMapping("/assessment")
	public String uploadAssessment(@RequestBody NewAssesment assesment) {
		System.out.println(assesment);
		return service.uploadAssesment(assesment);
	}
}
