package com.sakuraevent.tay.app.dto;

import java.util.List;

public class CategoryDTO {
	
	private Integer cID;
	private String categoryType;
	
	private List<EventDTO> events;

	
	
	public Integer getcID() {
		return cID;
	}

	public void setcID(Integer cID) {
		this.cID = cID;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public List<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventDTO> eventdtoList) {
		this.events = eventdtoList;
	}

	

	

	
	
	
	
}
