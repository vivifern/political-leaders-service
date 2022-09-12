package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Leader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Min(1)
	@Max(999)
	private Integer partyId;
	@Size(min = 5, max = 100)
	@Pattern(regexp = "^[a-zA-z\\s]*$")
	private String leaderName;
	@Size(min = 5, max = 100)
	@Pattern(regexp = "^[a-zA-z\\s]*$")
	private String leaderState;
	
	public Leader() {
	}
	
	public Leader(Integer partyId, String leaderName, String leaderState) {
		this.partyId = partyId;
		this.leaderName = leaderName;
		this.leaderState = leaderState;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getLeaderState() {
		return leaderState;
	}
	public void setLeaderState(String leaderState) {
		this.leaderState = leaderState;
	}

	@Override
	public String toString() {
		return "Leader [id=" + id + ", partyId=" + partyId + ", leaderName=" + leaderName + ", leaderState="
				+ leaderState + "]";
	}
	
}
