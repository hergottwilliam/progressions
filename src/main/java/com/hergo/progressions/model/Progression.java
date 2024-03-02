package com.hergo.progressions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Progression {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "exerciseId")
	private Exercise exercise;
	private String name;
	private int level;
	// IMAGE?
	
	protected Progression() {}
	
	
	public Progression(String name, int level) {

		this.name = name;
		this.level = level;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
