package com.trg.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("getForm")
public class IndexController {
	
	@RequestMapping()
	public String getEmpForm() {
		System.out.println("returning index");
		return "index";
	}

}
