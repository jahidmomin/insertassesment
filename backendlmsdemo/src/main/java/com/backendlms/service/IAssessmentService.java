package com.backendlms.service;

import java.util.List;

import com.backendlms.dto.AssesmentQuestionDTO;
import com.backendlms.model.Assesment;

public interface IAssessmentService {
	public long uploadAssessment(Assesment assesment);
	public List<AssesmentQuestionDTO> getAllAssesment();
	public List<AssesmentQuestionDTO> getAssesment(int id);
}
