package com.backendlms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question {
	private static final long serialVersionUID = 2472477195984170646L;

	private int questionId;
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", assessmentId=" + assessmentId + ", questionName="
				+ questionName + ", questionType=" + questionType + ", createdOn=" + createdOn + ", options=" + options
				+ ", is_active=" + is_active + ", correct_answer=" + correct_answer + "]";
	}

	private int assessmentId;
	private String questionName;
	private String questionType;
	private Date createdOn;
	private List<Option> options = new ArrayList<Option>();
	private int is_active;
	private String correct_answer;
	
	/**
	 * @return the questionId
	 */
	public int getQuestionId() {
		return questionId;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the assessmentId
	 */
	public int getAssessmentId() {
		return assessmentId;
	}

	/**
	 * @param assessmentId the assessmentId to set
	 */
	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	/**
	 * @return the questionName
	 */
	public String getQuestionName() {
		return questionName;
	}

	/**
	 * @param questionName the questionName to set
	 */
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	/**
	 * @return the questionType
	 */
	public String getQuestionType() {
		return questionType;
	}

	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the isActive
	 */
	public int getIsActive() {
		return is_active;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.is_active = isActive;
	}

	/**
	 * @return the options
	 */
	public List<Option> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(List<Option> options) {
		this.options = options;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
