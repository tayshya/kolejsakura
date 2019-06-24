package com.sakuraevent.tay.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakuraevent.tay.app.dto.EventDTO;
import com.sakuraevent.tay.app.dto.ParticipantDTO;
import com.sakuraevent.tay.app.entity.Category;
import com.sakuraevent.tay.app.entity.Event;
import com.sakuraevent.tay.app.entity.Participant;
import com.sakuraevent.tay.app.repository.CategoryRepository;
import com.sakuraevent.tay.app.repository.EventRepository;
import com.sakuraevent.tay.app.repository.ParticipantRepository;


@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ParticipantRepository participantRepository;
	
	
	public List<EventDTO> getAllEvents(){
		List<Event> eventList = new ArrayList<>();
		eventRepository.findAll().forEach(eventList::add);
		
		List<EventDTO> eventdtoList = new ArrayList<>();
		for (Event event : eventList) {
			EventDTO eventdto = new EventDTO();
			
			eventdto.seteID(event.getEID());
			eventdto.setEventName(event.getEventName());
			eventdto.setEventDescription(event.getEventDescription());
			
			
		List<ParticipantDTO> participantdtoList = new ArrayList<>();
			for (Participant participant : event.getParticipants()) {
				ParticipantDTO participantdto = new ParticipantDTO();
				
				participantdto.setpID(participant.getPID());
				participantdto.setParticipantName(participant.getParticipantName());
				
				
				participantdtoList.add(participantdto);
					
			} 
			
			eventdto.setParticipants(participantdtoList);
			eventdtoList.add(eventdto);	

		}
		return eventdtoList;
	}
	
	@Transactional
	public void addEvent(EventDTO eventdto) {
		
		Category categoryType = categoryRepository.findByCategoryType(eventdto.getCategoryType());
		Event event = new Event();
		
		event.setEID(eventdto.geteID());
		event.setEventName(eventdto.getEventName());
		event.setEventDescription(eventdto.getEventDescription());
		
		
		List categoryList = new ArrayList<>();
		categoryList.add(categoryType);
		
		event.setCategories(categoryList);
		
		Event savedEvent = eventRepository.save(event);
		
		List participantList = new ArrayList<>();
		for (ParticipantDTO participantdto : eventdto.getParticipants()) {
			Participant participant = new Participant();
		
			participant.setPID(participantdto.getpID());
			participant.setParticipantName(participantdto.getParticipantName());
			
			participant.setEvent(savedEvent);
			
			participantList.add(participant);		
			
			}
		
		participantRepository.save(participantList);
		
		}

	public void updateEvent(EventDTO eventdto) {
		Event event = eventRepository.findByeID(eventdto.geteID());
		Category categoryType = categoryRepository.findByCategoryType(eventdto.getCategoryType());
		
		event.setEventName(eventdto.getEventName());
		event.setEventDescription(eventdto.getEventDescription());
		
		List categoryList = new ArrayList<>();
		categoryList.add(categoryType);
		
		event.setCategories(categoryList);
		
		Event savedEvent =eventRepository.save(event);	
		
		List participantList = new ArrayList<>();
		for (ParticipantDTO participantdto : eventdto.getParticipants()) {
			Participant participant = new Participant();
			
			participant.setPID(participantdto.getpID());
			participant.setParticipantName(participantdto.getParticipantName());
			
			participant.setEvent(savedEvent);
		
			participantList.add(participant);
		}	
		
		participantRepository.save(participantList);
	}
	
	public void deleteEvent(int id) {
		
		eventRepository.delete(id);
		
	}
}