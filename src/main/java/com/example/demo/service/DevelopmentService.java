package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Development;

public interface DevelopmentService {

	public List<Development> fetchDevelopmentTasksOfLeader(Long leaderId);
	
}
