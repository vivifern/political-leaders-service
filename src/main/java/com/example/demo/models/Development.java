package com.example.demo.models;

public class Development {

	private Long id;
	private Long leaderId;
	private Integer partyId;
	private String developmentTitle;
	private String activity;
	private Long budget;
	private String state;
	private Byte activityMonth;
	private Short activityYear;
	
	protected Development() {
	}

	public Development(Long leaderId, Integer partyId, String developmentTitle, String activity, Long budget,
			String state, Byte activityMonth, Short activityYear) {
		super();
		this.leaderId = leaderId;
		this.partyId = partyId;
		this.developmentTitle = developmentTitle;
		this.activity = activity;
		this.budget = budget;
		this.state = state;
		this.activityMonth = activityMonth;
		this.activityYear = activityYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public String getDevelopmentTitle() {
		return developmentTitle;
	}

	public void setDevelopmentTitle(String developmentTitle) {
		this.developmentTitle = developmentTitle;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Byte getActivityMonth() {
		return activityMonth;
	}

	public void setActivityMonth(Byte activityMonth) {
		this.activityMonth = activityMonth;
	}

	public Short getActivityYear() {
		return activityYear;
	}

	public void setActivityYear(Short activityYear) {
		this.activityYear = activityYear;
	}

	@Override
	public String toString() {
		return "Development [id=" + id + ", leaderId=" + leaderId + ", partyId=" + partyId + ", developmentTitle="
				+ developmentTitle + ", activity=" + activity + ", budget=" + budget + ", state=" + state
				+ ", activityMonth=" + activityMonth + ", activityYear=" + activityYear + "]";
	}
	
}
