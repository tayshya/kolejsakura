package com.sakuraevent.tay.app.dto;

import com.sakuraevent.tay.app.entity.Event;

public class ParticipantDTO {
	
	private Integer pID;
	private String participantName;
	private Event event;
	
	
	
	
	public Integer getpID() {
		return pID;
	}
	public void setpID(Integer pID) {
		this.pID = pID;
	}
	
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
}
