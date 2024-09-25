package com.treinamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.Model.TaskModel;


@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

	
	
	
}
