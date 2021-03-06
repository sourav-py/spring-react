package com.trg.boot.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.trg.boot.model.AppResponse;
import com.trg.boot.model.Employee;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	static Map<Integer, Employee> data;

	static {
		data = new TreeMap<Integer, Employee>();

		data.put(100, new Employee(100, "Abhishek", 23000));
		data.put(200, new Employee(200, "Birbal", 34000));
		data.put(300, new Employee(300, "Charlie", 13000));
		data.put(400, new Employee(400, "Deepak", 14000));
	}
	
	
	@PostMapping()
	public ResponseEntity<?> saveEmployee(@RequestBody Employee e) {
		
		String message;
		String responseCode;
		
		if(data.containsKey(e.getEmpId())) {
			responseCode = "SAVEFAIL";
			message = "Error: Employee with id-" + e.getEmpId() + " already exists!!";
			return new ResponseEntity<AppResponse>(new AppResponse(responseCode,message),HttpStatus.BAD_REQUEST);
		}
		else {
			data.put(e.getEmpId(), e);
			responseCode = "SUCCESS";
			message = "Employee successfully created!!!";
			return new ResponseEntity<AppResponse>(new AppResponse(responseCode,message),HttpStatus.CREATED);
		}
		
		
	}
	
	@PutMapping()
	public AppResponse updateEmployee(@RequestBody Employee e) {
		String message;
		String responseCode;
		if(data.containsKey(e.getEmpId())) {
			data.put(e.getEmpId(), e);
			responseCode = "SUCCESS";
			message = "Employee successfully updated!!!";
		}
		else {
			responseCode = "UPDATEFAIL";
			message = "Error!! Employee with id-" + e.getEmpId() + " does not exists.";
		}
		
		AppResponse response = new AppResponse(responseCode,message);
		
		return response;
	}
	
	@GetMapping("{eid}")
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int empid){
		
		Employee e = data.get(empid);
		
		if(e == null) {
			return new ResponseEntity<AppResponse>(new AppResponse("NOTFND","Employee with id-" + empid + " does not exist"),HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Employee>(e,HttpStatus.OK);
		}
		
	
	
		
	}
	
	@GetMapping()
	public Collection<Employee> getAllEmployees() {
		Collection<Employee> col = data.values();
		
		return col;
	}
	
	@DeleteMapping("{eid}")
	public AppResponse deleteEmployee(@PathVariable("eid") int empid) {
		
		String message;
		String responseCode;
		
		if(data.containsKey(empid)) {
			data.remove(empid);
			responseCode = "SUCCESS";
			message = "Employee with id-" + empid + " successfully deleted.";
		}
		else {
			responseCode = "DELETEFAIL";
			message = "Error: Employee with id-" + empid + " does not exist.";
		}
		
		AppResponse response = new AppResponse(responseCode,message);
		
		return response;
	}
	
	
	
}
