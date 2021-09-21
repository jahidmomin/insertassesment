package com.backendlms.dto;

import java.sql.Date;

public class AssesmentQuestionDTO {
	private int assessmenId;
	private int questionId;
	private int qassesmentId;
	private String assessment_name;
	private String skills;
	private String description;
	private Date created_on;
	private String question_name;
	private String question_type;
	private int isactive;

	public AssesmentQuestionDTO(int assessmenId, int questionId, String assessment_name, String skills,
			String description, Date created_on, String question_name, String question_type) {
		super();
		this.assessmenId = assessmenId;
		this.questionId = questionId;
		this.assessment_name = assessment_name;
		this.skills = skills;
		this.description = description;
		this.created_on = created_on;
		this.question_name = question_name;
		this.question_type = question_type;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public int getAssessmenId() {
		return assessmenId;
	}

	public void setAssessmenId(int assessmenId) {
		this.assessmenId = assessmenId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAssessment_name() {
		return assessment_name;
	}

	public void setAssessment_name(String assessment_name) {
		this.assessment_name = assessment_name;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public String getQuestion_name() {
		return question_name;
	}

	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	public AssesmentQuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQassesmentId() {
		return qassesmentId;
	}

	public void setQassesmentId(int qassesmentId) {
		this.qassesmentId = qassesmentId;
	}

	@Override
	public String toString() {
		return "AssesmentQuestionDTO [assessmenId=" + assessmenId + ", questionId=" + questionId + ", assessment_name="
				+ assessment_name + ", skills=" + skills + ", description=" + description + ", created_on=" + created_on
				+ ", question_name=" + question_name + ", question_type=" + question_type + ", isactive=" + isactive
				+ "]";
	}

}
