package com.sakuraevent.tay.app.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the participant database table.
 * 
 */
@Entity
@Table(name="participant")
@NamedQuery(name="Participant.findAll", query="SELECT p FROM Participant p")
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer pID;

	@Column(name="participant_name", length=255)
	private String participantName;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;

	public Participant() {
	}

	public Integer getPID() {
		return this.pID;
	}

	public void setPID(Integer pID) {
		this.pID = pID;
	}

	public String getParticipantName() {
		return this.participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}