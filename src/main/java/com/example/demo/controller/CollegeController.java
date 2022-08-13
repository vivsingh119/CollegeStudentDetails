package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CollegeDao;
import com.example.demo.modal.College;
import com.example.demo.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {
	@Autowired
	private CollegeService service;
	@Autowired
	private CollegeDao dao;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody College college) {
		Integer id = null;
		if (college != null) {
			id = service.saveCollege(college);
		}
		return ResponseEntity.ok("College Saved with " + id);
	}

	@GetMapping("/get")
	public ResponseEntity<List<College>> findAllColleges() {
		return ResponseEntity.ok(dao.findAll());
	}

}
