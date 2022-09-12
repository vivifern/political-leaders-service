package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Leader;

public interface LeaderRepository extends CrudRepository<Leader, Long>{
	
	public List<Leader> findByLeaderNameAndPartyIdAndLeaderState(String leaderName, Integer partyId, String leaderState);
	
	public List<Leader> findByPartyId(Integer partyId);
	
	public Optional<Leader> findById(Long id);
	
}
