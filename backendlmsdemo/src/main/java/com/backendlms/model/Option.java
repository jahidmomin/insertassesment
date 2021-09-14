package com.backendlms.model;

public class Option {
	private int optionId;
	private int questionId;
	private String optionType;
	private String optionValue;
	private String createdDate;

	public Option(int questionId, String optionType, String optionValue) {
		super();
		this.questionId = questionId;
		this.optionType = optionType;
		this.optionValue = optionValue;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", questionId=" + questionId + ", optionType=" + optionType
				+ ", optionValue=" + optionValue + ", createdDate=" + createdDate + "]";
	}

}
