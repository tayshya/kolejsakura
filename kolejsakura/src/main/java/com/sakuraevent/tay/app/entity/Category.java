package com.sakuraevent.tay.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer cID;

	@Column(name="category_type", length=20)
	private String categoryType;

	//bi-directional many-to-many association to Event
	@ManyToMany(mappedBy="categories")
	private List<Event> events;

	public Category() {
	}

	public Integer getCID() {
		return this.cID;
	}

	public void setCID(Integer cID) {
		this.cID = cID;
	}

	public String getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}