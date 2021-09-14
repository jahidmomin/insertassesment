package com.backendlms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.backendlms.model.Assesment;
import com.backendlms.model.Option;
import com.backendlms.model.Question;
import com.backendlms.service.AssessmentService;

@Component
public class AssessmentDAO implements AssessmentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String QUERY1 = "INSERT INTO assesment(assessment_name,skills,description,is_active) "
			+ "VALUES (?,?,?,?)";
	private static final String QUERY2 = "INSERT INTO question(assessment_id,question_name,question_type,is_active) "
			+ "VALUES (?,?,?,?)";
	private static final String QUERY3 = "INSERT INTO option(question_id,options)"
			+ "VALUES (?,?)";

	public long uploadAssessment(Assesment assesment) {
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(QUERY1, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, assesment.getAssessmentName());
				statement.setString(2, assesment.getSkills());
				statement.setString(3, assesment.getDescription());
				statement.setInt(4, assesment.getIsActive());
				return statement;
			}
		}, holder);
		
		System.out.println(holder);
		long assesmentId = holder.getKey().longValue();
		System.out.println(assesmentId);
		
		System.out.println(assesment.getQuestions().size());
		
		for (Question question : assesment.getQuestions()) {
			System.out.println(question.getQuestionName());
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement statement = con.prepareStatement(QUERY2, Statement.RETURN_GENERATED_KEYS);
						statement.setLong(1, assesmentId);
						statement.setString(2, question.getQuestionName());
						statement.setString(3, question.getQuestionType());
						statement.setInt(4, question.getIsActive());
						return statement;			
				}
			}, holder);
			long questionId = holder.getKey().longValue();
			
			for (Option option : question.getOptions()) {
				System.out.println(option.getOptionValue());
				jdbcTemplate.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
						PreparedStatement statement = con.prepareStatement(QUERY3, Statement.RETURN_GENERATED_KEYS);
						statement.setLong(1, questionId);
						statement.setString(2,option.getOptionValue());
//						statement.setString(3, option.getOptionType());
						return statement;
					}
				}, holder);
			}
		}
		
		return assesmentId;
	}

}
