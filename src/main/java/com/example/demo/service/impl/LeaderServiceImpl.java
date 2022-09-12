package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.LeaderRepository;
import com.example.demo.models.Leader;
import com.example.demo.models.Leaders;
import com.example.demo.service.LeaderService;

@Service
public class LeaderServiceImpl implements LeaderService {
	
	private final String URI_FIND_PARTY = "http://localhost:8080/party/findParty";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LeaderRepository leaderRepository;

	@Override
	public String addLeader(Integer partyId, String leaderName, String leaderState) {
		String confirmationString = "Leader Added";
		Leader leader = new Leader(partyId, leaderName, leaderState);
		if(!leader.equals(leaderRepository.save(leader)))
				confirmationString = "Leader could not be Added";;
		return confirmationString;
	}

	@Override
	public String addLeader(Leader leader) {
		String confirmationString = "Leader Added";
		URIBuilder uriBuilder;
		try {
			uriBuilder = new URIBuilder(URI_FIND_PARTY);
			uriBuilder.addParameter("partyid", String.valueOf(leader.getPartyId()));
			if(!restTemplate.getForEntity(uriBuilder.toString(), Boolean.class).getBody()) {
				confirmationString="Party does not exist";
				return confirmationString;
			}
		} catch (Exception e) {
			confirmationString = "Party does not exist";
			return confirmationString;
		}
		if(!leader.equals(leaderRepository.save(leader)))
				confirmationString = "Leader could not be Added";
		return confirmationString;
	}

	@Override
	public Long findLeader(Integer partyId, String leaderName, String leaderState) {
		List<Leader> leaders = leaderRepository.findByLeaderNameAndPartyIdAndLeaderState
				(leaderName, partyId, leaderState);
		if((!CollectionUtils.isEmpty(leaders)) && Objects.nonNull(leaders.get(0)))
			return leaders.get(0).getId();
		return (long) 0;
	}

	@Override
	public Boolean removeLeader(Long leaderId) {
		try {
			leaderRepository.deleteById(leaderId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Leaders findLeaderByParty(Integer partyId) {
		return new Leaders(leaderRepository.findByPartyId(partyId));
	}

	@Override
	public Leader findLeaderById(Long leaderId) {
		try {
			return leaderRepository.findById(leaderId).get();
		} catch (Exception e) {
			Leader leader = new Leader();
			leader.setId(Long.valueOf(0));
			return leader;
		}
	}

}
