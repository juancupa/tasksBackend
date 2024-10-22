package com.task.repository;

import java.util.List;
import java.util.Optional;

import com.task.model.Task;

public interface ITaskRepository {
	
	Task save(Task task);
	List<Task> findAll();
	void deleteById(Long id);

}
