package com.hergo.progressions.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	
	private String name;
	private int currentLevel; // starts at 0
	
	@OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
	private List<Progression> progressions;
	
	protected Exercise() {}
	
	public Exercise(String name, int currentLevel) {
		this.name = name;
		this.currentLevel = currentLevel;
		
	}
	
	public Exercise(String name, int currentLevel, List<Progression> progressions) {
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
	
	public void deleteProgression(Long progressionId) {
		for (int i = 0; i < this.progressions.size(); i++) {
			if (this.progressions.get(i).getId() == progressionId) {
				if (this.progressions.get(i).getLevel() <= this.currentLevel) {
					this.currentLevel--;
				}
				this.progressions.remove(i);
				return;
			}
		}
	}
	
	public List<Progression> currentProgression() {
		List<Progression> current = new ArrayList<>();
		
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

	public long getId() {
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

	public List<Progression> getProgressions() {
		return progressions;
	}

	public void setProgressions(List<Progression> progressions) {
		this.progressions = progressions;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", currentLevel=" + currentLevel + ", progressions="
				+ progressions + "]";
	}


}
