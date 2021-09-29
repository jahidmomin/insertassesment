package com.backendlms.model;

import java.sql.Date;
import java.util.List;

public class NewAssesment {
	 public String name;
	    public String skills;
	    public String description;
	    public int isActive;
	    public Date validity_start_date;
	    public Date validity_end_date;
	    public String time_duration;
	    public String no_of_questions;
	    public String max_attempts_allowed;
	    public String createdOn;
	    public String created_by;
	    public AssesmentType assesment_type;
	    public List<NewQuestion> questions;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public int getIsActive() {
			return isActive;
		}
		public void setIsActive(int isActive) {
			this.isActive = isActive;
		}
		public Date getValidity_start_date() {
			return validity_start_date;
		}
		public void setValidity_start_date(Date validity_start_date) {
			this.validity_start_date = validity_start_date;
		}
		public Date getValidity_end_date() {
			return validity_end_date;
		}
		public void setValidity_end_date(Date validity_end_date) {
			this.validity_end_date = validity_end_date;
		}
		public String getTime_duration() {
			return time_duration;
		}
		public void setTime_duration(String time_duration) {
			this.time_duration = time_duration;
		}
		public String getNo_of_questions() {
			return no_of_questions;
		}
		public void setNo_of_questions(String no_of_questions) {
			this.no_of_questions = no_of_questions;
		}
		public String getMax_attempts_allowed() {
			return max_attempts_allowed;
		}
		public void setMax_attempts_allowed(String max_attempts_allowed) {
			this.max_attempts_allowed = max_attempts_allowed;
		}
		public String getCreatedOn() {
			return createdOn;
		}
		public void setCreatedOn(String createdOn) {
			this.createdOn = createdOn;
		}
		public String getCreated_by() {
			return created_by;
		}
		public void setCreated_by(String created_by) {
			this.created_by = created_by;
		}
		public AssesmentType getAssesment_type() {
			return assesment_type;
		}
		public void setAssesment_type(AssesmentType assesment_type) {
			this.assesment_type = assesment_type;
		}
		public List<NewQuestion> getQuestions() {
			return questions;
		}
		public void setQuestions(List<NewQuestion> questions) {
			this.questions = questions;
		}
		public NewAssesment(String name, String skills, String description, int isActive, Date validity_start_date,
				Date validity_end_date, String time_duration, String no_of_questions, String max_attempts_allowed,
				String createdOn, String created_by, AssesmentType assesment_type, List<NewQuestion> questions) {
			super();
			this.name = name;
			this.skills = skills;
			this.description = description;
			this.isActive = isActive;
			this.validity_start_date = validity_start_date;
			this.validity_end_date = validity_end_date;
			this.time_duration = time_duration;
			this.no_of_questions = no_of_questions;
			this.max_attempts_allowed = max_attempts_allowed;
			this.createdOn = createdOn;
			this.created_by = created_by;
			this.assesment_type = assesment_type;
			this.questions = questions;
		}
		@Override
		public String toString() {
			return "NewAssesment [name=" + name + ", skills=" + skills + ", description=" + description + ", isActive="
					+ isActive + ", validity_start_date=" + validity_start_date + ", validity_end_date="
					+ validity_end_date + ", time_duration=" + time_duration + ", no_of_questions=" + no_of_questions
					+ ", max_attempts_allowed=" + max_attempts_allowed + ", createdOn=" + createdOn + ", created_by="
					+ created_by + ", assesment_type=" + assesment_type + ", questions=" + questions + "]";
		}
	    
	    
}
