package com.task.service;

import java.util.List;
import java.util.Optional;

import com.task.model.Task;
import com.task.repository.ITaskRepository;




public class TaskService {

	
	private final ITaskRepository iTaskRepository;

	public TaskService(ITaskRepository iTaskRepository) {
		super();
		this.iTaskRepository = iTaskRepository;
	}
	
	
	public Task save(Task task) {
		
		return this.iTaskRepository.save(task);
	}
	
	public List<Task> findAll(){
		
		return this.iTaskRepository.findAll();
	}
	
	
	public void deleteById(Long id) {
		this.iTaskRepository.deleteById(id);
	}
	
}
