package com.hergo.progressions.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hergo.progressions.model.Exercise;
import com.hergo.progressions.model.Progression;
import com.hergo.progressions.repository.ExerciseRepository;

@Service
public class ExerciseService {
	
	// TODO
	// Establish business rules and enforce them
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	


	public String addNewExercise(Exercise exercise) {
		exerciseRepository.save(exercise);
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
	
	public Exercise getExerciseById(Long exerciseId) {
		return this.grabExercise(exerciseId);
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
		exerciseRepository.save(exercise);
		
		return "Success";
	}
	
	
	public Iterable<Progression> getAllProgressions(Long exerciseId) {
		Exercise exercise = this.grabExercise(exerciseId);
		
		return exercise.getProgressions();
	}
	
	public Iterable<Progression> getCurrentProgression(Long exerciseId) {
		Exercise exercise = this.grabExercise(exerciseId);
		return exercise.currentProgression();
	}
	
	public String updateProgression(Long exerciseId, Long progressionId, Progression progression) {
		Exercise exercise = this.grabExercise(exerciseId);
		List<Progression> progressions = exercise.getProgressions();
		
		for (int i = 0; i < progressions.size(); i++) {
			if (progressions.get(i).getId() == progressionId) {
				progressions.get(i).setName(progression.getName());
				progressions.get(i).setLevel(progression.getLevel());
				
				exerciseRepository.save(exercise);
				
				return "Success";
			}
		}
		
		return "Failed to update progression";
	}
	
	public String deleteProgression(Long exerciseId, Long progressionId) {
		Exercise exercise = this.grabExercise(exerciseId);
		
		exercise.deleteProgression(progressionId);
		
		exerciseRepository.save(exercise);
		
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
