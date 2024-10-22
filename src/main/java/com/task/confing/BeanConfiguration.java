package com.task.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.task.repository.ITaskRepository;
import com.task.service.TaskService;

@Configuration
public class BeanConfiguration {

	
	@Bean
	public TaskService taskService(ITaskRepository iTaskRepository) {
		
		return new TaskService(iTaskRepository);
	}
	
}
