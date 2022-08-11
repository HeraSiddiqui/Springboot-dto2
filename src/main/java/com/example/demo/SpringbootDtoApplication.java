package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Location;
import com.example.demo.model.Student;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@SpringBootApplication
public class SpringbootDtoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {

		Location location = new Location();
		location.setPlace("Delhi");
		location.setDescription("Delhi is the capital of India");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		Student student1 = new Student();
		student1.setFirstName("Jimmy");
		student1.setLastName("jackson");
		student1.setEmail("jimmy@gmail.com");
		student1.setPassword("secret");
		student1.setLocation(location);
		studentRepository.save(student1);

		Student student2 = new Student();
		student2.setFirstName("Wilson");
		student2.setLastName("Perry");
		student2.setEmail("wilson@gmail.com");
		student2.setPassword("secret");
		student2.setLocation(location);
		studentRepository.save(student2);
		}

}
