package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

public class Leaders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Leader> leaders;

	public Leaders() {

	}
	
	public Leaders(List<Leader> leaders) {
		this.leaders = leaders;
	}

	public List<Leader> getLeaders() {
		return leaders;
	}

	public void setLeaders(List<Leader> leaders) {
		this.leaders = leaders;
	}
}
