package com.task.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.task.model.Task;


@Repository
public interface ITaskCrudRepository extends JpaRepository<Task, Long> {
	
	@Query(value ="SELECT *  FROM Task ", nativeQuery = true)
	List<Task> getTask();

}
