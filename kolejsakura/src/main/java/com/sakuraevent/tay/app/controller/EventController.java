package com.sakuraevent.tay.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sakuraevent.tay.app.dto.CategoryDTO;
import com.sakuraevent.tay.app.dto.EventDTO;
import com.sakuraevent.tay.app.service.CategoryService;
import com.sakuraevent.tay.app.service.EventService;
import com.sakuraevent.tay.app.service.ParticipantService;


@RestController
@RequestMapping(path = "/sakuraevent")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ParticipantService participantService;
	
	//to get/retrieve all the events 
	//return all the event( dari repository)
	@GetMapping(path = "/event")
	public List<EventDTO> getAllEvents() {
		return eventService.getAllEvents();
	}
		
	@GetMapping(path = "/category")
	public List<CategoryDTO> getCategory() {
		return categoryService.getCategory();
	}
	
	//student create a event with the data to the eventdto.
	@RequestMapping(method = RequestMethod.POST, value = "/event")
	public void addEvent(@RequestBody EventDTO eventdto) {
		eventService.addEvent(eventdto);
	}
	
//	//update the event 
	@RequestMapping(method = RequestMethod.PUT, value = "/event")
	public void updateEvent(@RequestBody EventDTO eventdto) {
		eventService.updateEvent(eventdto);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/event/{id}")
	public void deleteEvent(@PathVariable("id") int id) {
		eventService.deleteEvent(id);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/event/participant/{pid}")
	public void deleteParticipant(@PathVariable("pid") int pid) {
		participantService.deleteParticipant(pid);
	}
}
