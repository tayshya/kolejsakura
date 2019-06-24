package com.sakuraevent.tay.app.dto;

import java.util.List;

public class EventDTO {
	
	private Integer eID;
	private String eventName;
	private String eventDescription;
	private String categoryType;
	
	private List<ParticipantDTO> participants;

	

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	
	public Integer geteID() {
		return eID;
	}

	public void seteID(Integer eID) {
		this.eID = eID;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public List<ParticipantDTO> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantDTO> participantdtoList) {
		this.participants = participantdtoList;
	}
	
	
	
	
	
	
	
}
