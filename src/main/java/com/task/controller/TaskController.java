package com.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Task;
import com.task.service.TaskService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/task")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
	private TaskService taskService;
	
	
	@PostMapping()
	public ResponseEntity<Task> sateTask(@RequestParam("title") String title,
										 @RequestParam("description") String description
			                            ){
		
		Task task = new Task();
		task.setTitle(title);
		task.setDescription(description);
		try {
			
			Task taskObj = this.taskService.save(task);
			return new ResponseEntity<>(taskObj, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		
	try {
		
		return ResponseEntity.ok(this.taskService.findAll());
		
		} catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		//return ResponseEntity.ok(this.taskService.findAll());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus>deleteById(@PathVariable Long id){
		
		this.taskService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
