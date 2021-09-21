package com.backendlms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backendlms.dto.AssesmentQuestionDTO;


public class AssesmentRowMapper implements RowMapper<AssesmentQuestionDTO>{

	@Override
	public AssesmentQuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AssesmentQuestionDTO assesment = new AssesmentQuestionDTO();
		
		assesment.setAssessmenId(rs.getInt(1));
		assesment.setQuestionId(rs.getInt(2));
		assesment.setAssessment_name(rs.getString(3));
		assesment.setSkills(rs.getString(4));
		assesment.setDescription(rs.getString(5));
		assesment.setCreated_on(rs.getDate(6));
		assesment.setIsactive(rs.getInt(7));
		assesment.setQuestion_name(rs.getString(8));
		assesment.setQuestion_type(rs.getString(9));
		assesment.setQassesmentId(rs.getInt(10));
		
		return assesment;
	}

}
