package com.skit.learning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skit.learning.dao.StudentDao;
import com.skit.learning.model.Student;

@RestController
@RequestMapping("api/student")
public class StudentController {
	
	@GetMapping("/all")
	public List<Student> getAllStudent() {
		StudentDao stDao = new StudentDao();
		return stDao.getAllStudent();
	}
	
	@PostMapping
	public void createStudent(@RequestBody Student student) {
		System.out.println("student "+student);
		StudentDao stDao = new StudentDao();
		stDao.save(student);
	}
}
