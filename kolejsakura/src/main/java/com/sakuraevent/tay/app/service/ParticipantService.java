package com.sakuraevent.tay.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakuraevent.tay.app.dto.ParticipantDTO;
import com.sakuraevent.tay.app.entity.Participant;
import com.sakuraevent.tay.app.repository.ParticipantRepository;

@Service
public class ParticipantService {
	
	@Autowired
	ParticipantRepository participantRepository;
	
	public List<ParticipantDTO> getParticipant(){
		
		List <Participant> participantList = new ArrayList<>(); 
		participantRepository.findAll().forEach(participantList::add);
		
		List<ParticipantDTO> participantdtoList = new ArrayList<>();
		for (Participant participant : participantList) {
			ParticipantDTO participantdto = new ParticipantDTO();
			
			participantdto.setpID(participant.getPID());
			participantdto.setParticipantName(participant.getParticipantName());
			
			participantdtoList.add(participantdto);
		}
		
		return participantdtoList;	
		}
	public void deleteParticipant(int pid) {
		participantRepository.delete(pid);
	}
	
}
