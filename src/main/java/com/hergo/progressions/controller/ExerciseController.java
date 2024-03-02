package com.hergo.progressions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hergo.progressions.model.Exercise;
import com.hergo.progressions.model.Progression;
import com.hergo.progressions.service.ExerciseService;

@Controller
@RequestMapping(path="/exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	/* TODO
	 * 
	 * Changes entire api to Path variable for id? Cleaner names?
	 * 
	 * Add:
	 * 		get exercise by id
	 * 
	 * 	crud for progressions:
	 * 		delete progression from exercise
	 * 		update progression
	 * 		get all progressions for an exercise
	 * 		get current progression for an exercise
	 * 
	 * TEST EVERYTHING
	 * 
	*/
	

	@PostMapping(path="/add")
	public @ResponseBody String addNewExercise(@RequestParam String name, @RequestParam int currentLevel) {
		Exercise newExercise = new Exercise(name, currentLevel);
		System.out.println("Controller: " + newExercise);
		return exerciseService.addNewExercise(newExercise);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Exercise> getAllExercise(){
		return exerciseService.getAllExercise();
	}
	
	@PutMapping(path="/{exerciseId}/update")
	public @ResponseBody String updateExercise(@PathVariable Long exerciseId, @RequestParam Exercise exercise) {
		return exerciseService.updateExercise(exerciseId, exercise);
	}
	
	
	@DeleteMapping(path="/delete")
	public @ResponseBody String deleteExerciseById(@RequestParam Long exerciseId) {
		return exerciseService.deleteExerciseById(exerciseId);
	}
	
	@PostMapping(path="/{exerciseId}/progression")
	public @ResponseBody String addProgression(@PathVariable Long exerciseId, @RequestParam Progression progression) { 
		return exerciseService.addProgression(exerciseId, progression);
	}
	
	@PutMapping(path="/{exerciseId/increase")
	public @ResponseBody String increaseLevel(@PathVariable Long exerciseId) {
		return exerciseService.increaseLevel(exerciseId);
	}
}
