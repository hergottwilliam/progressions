package com.hergo.progressions.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Exercise {
	
	private @Id @GeneratedValue int id;
	private String name;
	private int currentLevel;
	private ArrayList<Progression> progressions;
	
	
	public Exercise(int id, String name, int currentLevel, ArrayList<Progression> progressions) {
		this.id = id;
		this.name = name;
		this.currentLevel = currentLevel;
		this.progressions = progressions;
	}

	public void addProgression(Progression progression) {
		try {
			this.progressions.add(progression);
			
			if (progression.getLevel() <= this.currentLevel) { // maintain current progression
				this.increaseLevel();
			}			
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Progression> currentProgression() {
		ArrayList<Progression> current = new ArrayList<>();
		
		for (int i = 0; i < this.progressions.size(); i++) {
			if (this.progressions.get(i).getLevel() == this.currentLevel) {
				current.add(this.progressions.get(i));
			}
		}
		
		return current;
	}
	
	public void increaseLevel() {
		if(!this.isMaxLevel()) {
			this.currentLevel++;
		}

	}
	
	public boolean isMaxLevel() {
		if (this.currentLevel >= this.progressions.size() - 1) { // check for max level
			return true;
		} else {
			return false;	
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public ArrayList<Progression> getProgressions() {
		return progressions;
	}

	public void setProgressions(ArrayList<Progression> progressions) {
		this.progressions = progressions;
	}
	
	

}
