package com.sakuraevent.tay.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sakuraevent.tay.app.entity.Participant;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Integer> {
	
}
