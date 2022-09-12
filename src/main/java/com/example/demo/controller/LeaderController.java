package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Leader;
import com.example.demo.service.DevelopmentService;
import com.example.demo.service.LeaderService;

@RestController
@RequestMapping("/leader")
public class LeaderController {

	@Autowired
	public LeaderService leaderService;
	
	@Autowired
	public DevelopmentService developmentService;
	
	@PostMapping(path = "/addleader")
	public ResponseEntity<?> addParty(@Valid @RequestBody Leader leader) {
		return ResponseEntity.ok(leaderService.addLeader(leader));
	}
	
	@GetMapping(path = "/findleader")
	public ResponseEntity<?> findLeader(@RequestParam(name = "leadername", required = false) String leadername, @RequestParam(required = false) String partyid, @RequestParam(required = false) String leaderstate) {
		return ResponseEntity.ok(leaderService.findLeader(Integer.valueOf(partyid), leadername, leaderstate));
	}
	
	@GetMapping(path = "/findleaderbyparty")
	public ResponseEntity<?> findLeaderByPartyId(@RequestParam String partyid) {
		return ResponseEntity.ok(leaderService.findLeaderByParty(Integer.valueOf(partyid)));
	}
	
	@DeleteMapping(path = "/removeleader")
	public ResponseEntity<?> deleteLeader(@RequestParam String leaderid) {
		return ResponseEntity.ok(leaderService.removeLeader(Long.valueOf(leaderid)));
	}
	
	@GetMapping(path = "/findleaderbyid")
	public ResponseEntity<?> findLeaderById(@RequestParam String leaderid) {
		return ResponseEntity.ok(leaderService.findLeaderById(Long.valueOf(leaderid)).getId());
	}
	
	@GetMapping(path = "/findleadertask")
	public ResponseEntity<?> findLeadersTasks(@RequestParam String leaderid) {
		return ResponseEntity.ok(developmentService.fetchDevelopmentTasksOfLeader(Long.valueOf(leaderid)));
	}
}
