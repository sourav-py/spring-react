package com.trg.boot;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trg.boot.entity.Employee;
import com.trg.boot.repo.EmployeeRepository;

@Component
public class DBInit implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(DBInit.class);
	
	@Autowired
	EmployeeRepository repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		logger.info("Check database");
		
	}

}
