package com.example.demo.service;

import com.example.demo.models.Leader;
import com.example.demo.models.Leaders;

public interface LeaderService {

	public String addLeader(Integer partyId, String leaderName, String leaderState);
	
	public String addLeader(Leader leader);
	
	public Long findLeader(Integer partyId, String leaderName, String leaderState);
	
	public Boolean removeLeader(Long leaderId);
	
	public Leaders findLeaderByParty(Integer partyId);
	
	public Leader findLeaderById(Long leaderId);
	
}
