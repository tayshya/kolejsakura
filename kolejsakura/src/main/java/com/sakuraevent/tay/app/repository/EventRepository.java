package com.sakuraevent.tay.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sakuraevent.tay.app.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
	
	Event findByeID(Integer geteID);
	
	
	
}