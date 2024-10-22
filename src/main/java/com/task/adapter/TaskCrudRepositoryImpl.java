package com.task.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.task.model.Task;
import com.task.repository.ITaskRepository;

@Repository
public class TaskCrudRepositoryImpl implements ITaskRepository{
	
	private final ITaskCrudRepository iTaskCrudRepository;
	
	
	public TaskCrudRepositoryImpl(ITaskCrudRepository iTaskCrudRepository) {
		super();
		this.iTaskCrudRepository = iTaskCrudRepository;
	}

	
	
	
	@Override
	public Task save(Task task) {
	
		return Optional.ofNullable(task)
				.map(this.iTaskCrudRepository :: save)
				.orElseThrow(() -> new RuntimeException("Error al gardar la task"));
		
		
	}

	@Override
	public List<Task> findAll() {
		
		List<Task> taskRespon= iTaskCrudRepository.getTask();
		if(taskRespon.isEmpty()) {
			
			System.out.println("No data");
		}
		
		return taskRespon;
	}

	@Override
	public void deleteById(Long id) {
		
		Task ts = this.iTaskCrudRepository.findById(id)
							.orElseThrow(() -> new RuntimeException("Error task no encontrada"));
		
		this.iTaskCrudRepository.delete(ts);
					
		
		
		
		
	}

}
