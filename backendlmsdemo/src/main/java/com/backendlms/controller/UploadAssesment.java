package com.backendlms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backendlms.dto.AssesmentQuestionDTO;
import com.backendlms.model.Assesment;
import com.backendlms.model.Question;
import com.backendlms.service.AssessmentService;

@RestController
public class UploadAssesment {

	@Autowired
	private AssessmentService assessmentService;

	@PostMapping("/uploadassessment")
	public long uploadAssessment(@RequestBody Assesment assesment) {
		System.out.println(assesment);
		System.out.println(assessmentService);
		long assessmentId = this.assessmentService.uploadAssessment(assesment);
		return assessmentId;
	}

	@GetMapping("/assesments")
	public List<Assesment> getAllAssesment() {
		List<Assesment> assesments = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		List<AssesmentQuestionDTO> assesmentsdto = assessmentService.getAllAssesment();

		assesmentsdto.forEach(record -> {
			
				Assesment assesment = new Assesment();
				assesment.setAssesmentId(record.getAssessmenId());
				assesment.setAssessmentName(record.getAssessment_name());
				assesment.setDescription(record.getDescription());
				assesment.setSkills(record.getSkills());
				assesment.setCreatedOn(record.getCreated_on());

			if (assesment.getAssesmentId() == record.getQassesmentId()) {
				Question question = new Question();
				System.out.println(record.getQassesmentId() + " " + record.getAssessmenId());

				question.setQuestionId(record.getQuestionId());
				question.setAssessmentId(record.getAssessmenId());
				question.setQuestionName(record.getQuestion_name());
				question.setQuestionType(record.getQuestion_type());
				questions.add(question);

				assesment.setQuestions(questions);
				assesments.add(assesment);
			}
		});

		return assesments;
	}

	@GetMapping("/assesment/{id}")
	public Assesment getAssesment(@PathVariable("id") int id) {
		List<AssesmentQuestionDTO> assesmentQuestionDTOs = assessmentService.getAssesment(id);

		Assesment assesment = new Assesment();
		List<Question> questions = new ArrayList<>();
		assesmentQuestionDTOs.forEach(record -> {
			assesment.setAssesmentId(record.getAssessmenId());
			assesment.setAssessmentName(record.getAssessment_name());
			assesment.setCreatedOn(record.getCreated_on());
			assesment.setDescription(record.getDescription());
			assesment.setSkills(record.getSkills());

			Question q = new Question();
			q.setQuestionId(record.getQuestionId());
			q.setAssessmentId(record.getAssessmenId());
			q.setQuestionName(record.getQuestion_name());
			q.setQuestionType(record.getQuestion_type());
			questions.add(q);

		});
		assesment.setQuestions(questions);
		System.out.println(assesment);
		return assesment;
	}
}
