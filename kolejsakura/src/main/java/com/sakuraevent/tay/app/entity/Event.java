package com.sakuraevent.tay.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@Table(name="event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer eID;

	@Column(name="event_description", length=255)
	private String eventDescription;

	@Column(name="event_name", length=30)
	private String eventName;

	//bi-directional many-to-many association to Category
	@ManyToMany
	@JoinTable(
		name="event_category"
		, joinColumns={
			@JoinColumn(name="event_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="category_id", nullable=false)
			}
		)
	private List<Category> categories;

	//bi-directional many-to-one association to Participant
	@OneToMany(mappedBy="event")
	private List<Participant> participants;

	public Event() {
	}

	public Integer getEID() {
		return this.eID;
	}

	public void setEID(Integer eID) {
		this.eID = eID;
	}

	public String getEventDescription() {
		return this.eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(Participant participant) {
		getParticipants().add(participant);
		participant.setEvent(this);

		return participant;
	}

	public Participant removeParticipant(Participant participant) {
		getParticipants().remove(participant);
		participant.setEvent(null);

		return participant;
	}

}