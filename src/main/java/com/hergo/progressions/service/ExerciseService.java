package com.hergo.progressions.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hergo.progressions.model.Exercise;
import com.hergo.progressions.model.Progression;
import com.hergo.progressions.repository.ExerciseRepository;

@Service
public class ExerciseService {
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	


	public String addNewExercise(Exercise exercise) {
		exerciseRepository.save(exercise);
		System.out.println("Service: " + exercise);
		return "Success";
	}
	
	public Iterable<Exercise> getAllExercise(){
		return exerciseRepository.findAll();
	}
	
	public String updateExercise(Long exerciseId, Exercise exercise) {
		
		Exercise existingExercise = this.grabExercise(exerciseId);
		
		existingExercise.setName(exercise.getName());
		existingExercise.setCurrentLevel(exercise.getCurrentLevel());
		existingExercise.setProgressions(exercise.getProgressions());
		
		
		exerciseRepository.save(existingExercise);
		return "Success";
	}
	
	public String deleteExerciseById(Long exerciseId) {
		exerciseRepository.deleteById(exerciseId);
		return "Success";
	}
	
	
	
	public String addProgression(Long exerciseId, Progression progression) {
		
		Exercise exercise = this.grabExercise(exerciseId);
		
		exercise.addProgression(progression);
		
		exerciseRepository.save(exercise);
		
		return "Success";
	}
	
	
	
	public String increaseLevel(Long exerciseId) {
		Exercise exercise = this.grabExercise(exerciseId);
		
		exercise.increaseLevel();
		
		return "Success";
	}
	
	
	
	public Exercise grabExercise(Long exerciseId) {
		Optional<Exercise> existingExerciseOptional = exerciseRepository.findById(exerciseId);
		
		if (!existingExerciseOptional.isPresent()) { // if the exercise does not exist
			return null;
		}
		
		Exercise existingExercise = existingExerciseOptional.get();
		
		return existingExercise;
	}

}
