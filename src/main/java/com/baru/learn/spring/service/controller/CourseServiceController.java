package com.baru.learn.spring.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseServiceController {
	
	@RequestMapping("/welcome")
	public String courseHello() {
		return "Welcome to Course Management System !";
	}
}
