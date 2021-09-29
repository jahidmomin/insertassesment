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

import com.backendlms.model.AssesmentType;
import com.backendlms.model.NewAssesment;
import com.backendlms.model.NewQuestion;

@Component
public class UploadDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String QUERY1 = "INSERT INTO v_assesment_type_d(assesment_type_id,assesment_type,assesment_level)VALUES(?,?,?)";

	private static final String QUERY2 = "INSERT INTO v_assesment_d(assesment_id,is_active,"
			+ "name,description,validity_start_date,validity_end_date,time_duration,no_of_questions,max_attempts_allowed,assesment_type_id,created_by)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String QUERY3 = "INSERT INTO v_assesment_questionare(question_id,question_name,value_1,value_2,value_3,value_4,value_5,question_score,assesment_id,question_type, correct_answer,severity_level)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public String uploadAssesment(NewAssesment assesment) {
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
//		inserting in assesment type table
		String assesmentTypeId = "DEMO";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(QUERY1, Statement.RETURN_GENERATED_KEYS);
				// insert values/params
				AssesmentType assesmentType = assesment.getAssesment_type();
				statement.setString(1, assesmentTypeId);
				statement.setString(2, assesmentType.getAssesment_type());
				statement.setString(3, assesmentType.getAssesment_level());
				return statement;
			}
		}, holder);
//		long assesmentTypeId = holder.getKey().longValue();

//		insert assessment values

		String assesmentId = "ASS101";

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(java.sql.Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(QUERY2, Statement.RETURN_GENERATED_KEYS);

				statement.setString(1, assesmentId);
				statement.setInt(2, assesment.getIsActive());
				statement.setString(3, assesment.getName());
				statement.setString(4, assesment.getDescription());
				statement.setDate(5, assesment.getValidity_start_date());
				statement.setDate(6, assesment.getValidity_end_date());
				statement.setString(7, assesment.getTime_duration());
				statement.setString(8, assesment.getNo_of_questions());
				statement.setString(9, assesment.getMax_attempts_allowed());
				statement.setString(10, assesmentTypeId);
				statement.setString(11, assesment.getCreated_by());
				return statement;
			}
		}, holder);

//		insert questions table values
		for (NewQuestion question : assesment.getQuestions()) {
			int i = 1;
			String questionId = "QUE" + i;
			System.out.println(question.getQuestionName());
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement statement = con.prepareStatement(QUERY3, Statement.RETURN_GENERATED_KEYS);

					statement.setString(1, questionId);
					statement.setString(2, question.getQuestionName());
					statement.setString(3, question.getValue_1());
					statement.setString(4, question.getValue_2());
					statement.setString(5, question.getValue_3());
					statement.setString(6, question.getValue_4());
					statement.setString(7, question.getValue_5());
					statement.setString(8, question.getQuestion_score());
					statement.setString(9, assesmentId);
					statement.setString(10, question.getQuestion_type());
					statement.setString(11, question.getCorrect_answer());
					statement.setString(12, question.getSeverity_level());
					return statement;
				}
			}, holder);
			i++;
		}

		return assesmentId;
	}

}
