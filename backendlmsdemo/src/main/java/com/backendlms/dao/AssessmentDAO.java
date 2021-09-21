package com.backendlms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.backendlms.dto.AssesmentQuestionDTO;
import com.backendlms.mapper.AssesmentRowMapper;
import com.backendlms.model.Assesment;
import com.backendlms.model.Option;
import com.backendlms.model.Question;
import com.backendlms.service.IAssessmentService;

@Component
public class AssessmentDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String QUERY1 = "INSERT INTO assesment(assessment_name,skills,description,is_active) "
			+ "VALUES (?,?,?,?)";
	private static final String QUERY2 = "INSERT INTO question(assessment_id,question_name,question_type,is_active) "
			+ "VALUES (?,?,?,?)";
	private static final String QUERY3 = "INSERT INTO options(question_id,options)"
			+ "VALUES (?,?)";
	
	private static final String QUERY4="SELECT * FROM assesment JOIN question ON assesment.assesment_id = question.assessment_id "
			+ "JOIN options ON question.question_id = options.question_id";
	
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

	public List<AssesmentQuestionDTO> getAllAssesment() {
		String query="SELECT asm.assesment_id,qut.question_id,asm.assessment_name,asm.skills,asm.description,asm.created_on,asm.is_active,qut.question_name,qut.question_type , qut.assessment_id FROM smartgig.assesment asm, smartgig.question qut where asm.assesment_id = qut.assessment_id";
		
		RowMapper<AssesmentQuestionDTO> rowMapper=new AssesmentRowMapper();
		List<AssesmentQuestionDTO> assesment=jdbcTemplate.query(query,rowMapper);
	
		assesment.forEach(record->{
			System.out.println(record);
		});
		
		return assesment;
	}

	public List<AssesmentQuestionDTO> getAssesment(int id) {
		String query="SELECT asm.assesment_id,qut.question_id ,asm.assessment_name,asm.skills,asm.description,asm.created_on,asm.is_active,qut.question_name , qut.question_type ,qut.assessment_id   \r\n"
				+ "FROM smartgig.assesment asm, smartgig.question qut\r\n"
				+ "where asm.assesment_id = qut.assessment_id \r\n"
				+ "and asm.assesment_id= ?;";
		
		RowMapper<AssesmentQuestionDTO> rowMapper=new AssesmentRowMapper();
		List<AssesmentQuestionDTO> assesment=jdbcTemplate.query(query,rowMapper,id);
//		for (AssesmentQuestionDTO assesmentQuestionDTO : assesment) {
//			System.out.println(assesmentQuestionDTO.);
//		}
		return assesment;
	}
}
