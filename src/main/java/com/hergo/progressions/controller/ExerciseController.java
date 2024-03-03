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
	 * TEST EVERYTHING
	 * 
	*/
	

	@PostMapping(path="/add")
	public @ResponseBody String addNewExercise(@RequestParam String name, @RequestParam int currentLevel) {
		Exercise newExercise = new Exercise(name, currentLevel);
		return exerciseService.addNewExercise(newExercise);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Exercise> getAllExercise(){
		return exerciseService.getAllExercise();
	}
	
	@GetMapping(path="/{exerciseId}")
	public @ResponseBody Exercise getExerciseById(@PathVariable Long exerciseId) {
		return exerciseService.getExerciseById(exerciseId);
	}
	
	@PutMapping(path="/{exerciseId}/update")
	public @ResponseBody String updateExercise(@PathVariable Long exerciseId, @RequestParam Exercise exercise) {
		return exerciseService.updateExercise(exerciseId, exercise);
	}
	
	@DeleteMapping(path="/{exerciseId}/delete")
	public @ResponseBody String deleteExerciseById(@PathVariable Long exerciseId) {
		return exerciseService.deleteExerciseById(exerciseId);
	}
	
	@PutMapping(path="/{exerciseId}/increase")
	public @ResponseBody String increaseLevel(@PathVariable Long exerciseId) {
		return exerciseService.increaseLevel(exerciseId);
	}
	
	@PostMapping(path="/{exerciseId}/addprogression")
	public @ResponseBody String addProgression(@PathVariable Long exerciseId, @RequestParam Progression progression) { 
		return exerciseService.addProgression(exerciseId, progression);
	}
	
	@GetMapping(path="/{exerciseId}/allprogressions")
	public @ResponseBody Iterable<Progression> getAllProgressions(@PathVariable Long exerciseId) {
		return exerciseService.getAllProgressions(exerciseId);
	}
	
	@GetMapping(path="/{exerciseId}/current")
	public @ResponseBody Iterable<Progression> getCurrentProgression(@PathVariable Long exerciseId) {
		return exerciseService.getCurrentProgression(exerciseId);
	}
	
	@PutMapping(path="/{exerciseId}/{progressionId}/update")
	public @ResponseBody String updateProgression(@PathVariable Long exerciseId, @PathVariable Long progressionId, @RequestParam Progression progression) {
		return exerciseService.updateProgression(exerciseId, progressionId, progression);
	}
	
	@DeleteMapping(path="/{exerciseId}/{progressionId}/delete")
	public @ResponseBody String deleteProgression(@PathVariable Long exerciseId, @PathVariable Long progressionId) {
		return exerciseService.deleteProgression(exerciseId, progressionId);
	}
}
