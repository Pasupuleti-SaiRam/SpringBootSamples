package com.scheduler.entity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scheduler.repository.StudentRepo;

@Component
public class DeleteInactiveUsersJob {
	
	@Autowired
	private StudentRepo repo;


	private static final Logger logger = LoggerFactory.getLogger(DeleteInactiveUsersJob.class);
	
	public void deleteInactiveUsers()
	{
		List<Student> inactiveStudent = repo.findByActiveFalse();
		logger.info("InactiveStudent in the Class ::"+ inactiveStudent );
		repo.deleteAll(inactiveStudent);
		logger.info("InactiveStudent-Scheduled removed ::"+ inactiveStudent );
	}
	
	
	
}
