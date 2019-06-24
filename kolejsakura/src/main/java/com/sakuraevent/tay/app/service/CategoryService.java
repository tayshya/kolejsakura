package com.sakuraevent.tay.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakuraevent.tay.app.dto.CategoryDTO;
import com.sakuraevent.tay.app.dto.EventDTO;
import com.sakuraevent.tay.app.dto.ParticipantDTO;
import com.sakuraevent.tay.app.entity.Category;
import com.sakuraevent.tay.app.entity.Event;
import com.sakuraevent.tay.app.entity.Participant;
import com.sakuraevent.tay.app.repository.CategoryRepository;



@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	
	public List<CategoryDTO> getCategory(){
		
		List<Category> categoryList = new ArrayList<>();
		categoryRepository.findAll().forEach(categoryList::add);
	
		List<CategoryDTO>categorydtoList = new ArrayList<>();
		for (Category category : categoryList) {
			CategoryDTO categorydto = new CategoryDTO();
			
			categorydto.setcID(category.getCID());
			categorydto.setCategoryType(category.getCategoryType());
			
			List<EventDTO> eventdtoList = new ArrayList<>();
			for (Event event : category.getEvents()){
				EventDTO eventdto = new EventDTO();
				
				eventdto.setCategoryType(categorydto.getCategoryType());
				eventdto.seteID(event.getEID());
				eventdto.setEventName(event.getEventName());
				eventdto.setEventDescription(event.getEventDescription());
				
				List<ParticipantDTO> participantdtoList = new ArrayList<>();
				
				for (Participant participant : event.getParticipants()){
					ParticipantDTO participantdto= new ParticipantDTO ();
					
					participantdto.setpID(participant.getPID());
					participantdto.setParticipantName(participant.getParticipantName());
					
					participantdtoList.add(participantdto);
					
				}
					eventdto.setParticipants(participantdtoList);
					eventdtoList.add(eventdto);	
			}
				categorydto.setEvents(eventdtoList);
				categorydtoList.add(categorydto);
				}
		
		return categorydtoList;
	}
}

