package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentLocationDTO;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students-location")
	public List<StudentLocationDTO> getAllStudentsLocation() {
		return studentService.getAllStudentsLocation();		
	}
	

}
