package com.backendlms.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backendlms.model.Assesment;
import com.backendlms.service.AssessmentService;

@RestController
public class UploadAssesment {
	
	@Autowired
	private AssessmentService assessmentService;
	
	@PostMapping("/uploadassessment")
	public long uploadAssessment(@RequestBody Assesment assesment) {
		System.out.println(assesment);
		System.out.println(assessmentService);
		long assessmentId=this.assessmentService.uploadAssessment(assesment);
		return assessmentId;
	}
}
