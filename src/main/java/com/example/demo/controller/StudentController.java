package com.example.demo.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CollegeDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.modal.College;
import com.example.demo.modal.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CollegeDao collegeDao;

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		Integer id = null;
		if (student != null) {
			College collge = collegeDao.getById(3);
			student.setCollge(collge);
			id = studentDao.save(student).getId();
		}
		return ResponseEntity.ok("Student saved with " + id);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Student>> getStudent() {
		List<Student> allStudent = studentDao.findAll();
		Collections.sort(allStudent,
				(o1, o2) -> o1.getCollge().getCllgeName().compareTo(o2.getCollge().getCllgeName()));
		return ResponseEntity.ok(studentDao.findAll());
	}

}
