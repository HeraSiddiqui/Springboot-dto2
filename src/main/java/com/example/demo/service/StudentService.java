package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentLocationDTO;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<StudentLocationDTO> getAllStudentsLocation(){
        return studentRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());		
		
	}
	
	private StudentLocationDTO convertEntityToDto(Student student) {
		StudentLocationDTO studentLocationDTO = new StudentLocationDTO();
		studentLocationDTO.setStudentId(student.getId());
		studentLocationDTO.setEmail(student.getEmail());
		studentLocationDTO.setPlace(student.getLocation().getPlace());
		studentLocationDTO.setLongitude(student.getLocation().getLongitude());
		studentLocationDTO.setLatitude(student.getLocation().getLatitude());
		return studentLocationDTO;
		
	}
}
