package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CollegeDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.modal.College;

@Service
public class CollegeService {
	@Autowired
	private CollegeDao collegeDao;
	@Autowired
	private StudentDao studentdao;

	public Integer saveCollege(College cllge) {
		Integer id = collegeDao.save(cllge).getCllgeId();
		return id;
	}
}
