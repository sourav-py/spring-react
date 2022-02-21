package com.trg.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trg.model.Employee;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	static Map<Integer, Employee> data;

	static {
		data = new HashMap<Integer, Employee>();

		data.put(100, new Employee(100, "Abhishek", 23000));
		data.put(200, new Employee(200, "Birbal", 34000));
		data.put(300, new Employee(300, "Charlie", 13000));
		data.put(400, new Employee(400, "Deepak", 14000));
	}
	
	@RequestMapping("{eid}")
	public ModelAndView getEmployee(@PathVariable("eid") int empid){
		
		Employee e = data.get(empid);
		if(e != null) {
			return new ModelAndView("empdetails","emp",e);
		}
		else {
			return new ModelAndView("response","msg","Employee with id-"+empid+ " not found!!");
		}
		
		
	}
	
}