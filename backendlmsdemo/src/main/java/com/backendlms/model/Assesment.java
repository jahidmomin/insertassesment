package com.backendlms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Jahid
 *
 */
@Component
public class Assesment implements Serializable {

	private static final long serialVersionUID = -3719790626612628987L;

	private int assesmentId;
	private String assessmentName;
	private String skills;
	private Date createdOn;
	private String description;
	private int isActive;
	private List<Question> questions = new ArrayList<Question>();

	/**
	 * @return the assesmentId
	 */
	public int getAssesmentId() {
		return assesmentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param assesmentId the assesmentId to set
	 */
	public void setAssesmentId(int assesmentId) {
		this.assesmentId = assesmentId;
	}

	/**
	 * @return the assessmentName
	 */
	public String getAssessmentName() {
		return assessmentName;
	}

	/**
	 * @param assessmentName the assessmentName to set
	 */
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
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
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Assesment [assesmentId=" + assesmentId + ", assessmentName=" + assessmentName + ", skills=" + skills
				+ ", createdOn=" + createdOn + ", description=" + description + ", isActive=" + isActive
				+ ", questions=" + questions + "]";
	}
}
