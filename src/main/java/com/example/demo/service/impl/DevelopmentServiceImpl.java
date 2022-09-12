package com.example.demo.service.impl;

import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Development;
import com.example.demo.models.Developments;
import com.example.demo.service.DevelopmentService;

@Service
public class DevelopmentServiceImpl implements DevelopmentService{

	private final String URI_LEADER_TASKS = "http://localhost:8082/developer/getalldevelopments";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Development> fetchDevelopmentTasksOfLeader(Long leaderId) {
		String tasksUrl = urlBuilderString(URI_LEADER_TASKS, "leaderid", String.valueOf(leaderId));
		return restTemplate.getForEntity(tasksUrl, Developments.class).getBody().getDevelopments();
	}

	private String urlBuilderString(String url, String paramname, String paramvalue) {
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			uriBuilder.addParameter(paramname, paramvalue);
			return uriBuilder.toString();
		}
		catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
