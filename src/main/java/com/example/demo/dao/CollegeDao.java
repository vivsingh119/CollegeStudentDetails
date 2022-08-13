package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.College;

public interface CollegeDao extends JpaRepository<College, Integer> {

}
