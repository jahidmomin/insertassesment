package com.backendlms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backendlms.dao.AssessmentDAO;
import com.backendlms.dto.AssesmentQuestionDTO;
import com.backendlms.model.Assesment;

@Component
public class AssesmentServiceImpl implements IAssessmentService {

	@Autowired
	private AssessmentDAO dao;
	
	@Override
	public long uploadAssessment(Assesment assesment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AssesmentQuestionDTO> getAllAssesment() {
		List<AssesmentQuestionDTO> list=dao.getAllAssesment();
		return list;
	}

	@Override
	public List<AssesmentQuestionDTO> getAssesment(int id) {
		return dao.getAssesment(id);
	}

}
