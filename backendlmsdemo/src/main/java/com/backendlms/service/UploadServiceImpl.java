package com.backendlms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backendlms.dao.UploadDao;
import com.backendlms.model.NewAssesment;

@Component
public class UploadServiceImpl implements IUploadService {

	@Autowired
	private UploadDao dao;
	
	@Override
	public String uploadAssesment(NewAssesment assesment) {
		return dao.uploadAssesment(assesment);
	}

}
