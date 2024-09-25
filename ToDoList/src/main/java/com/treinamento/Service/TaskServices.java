package com.treinamento.Service;

import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.treinamento.Model.TaskModel;
import com.treinamento.Repository.TaskRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TaskServices {

	
	private TaskRepository taskRepository;
	
	
	
	public TaskModel createTask(TaskModel taskModel){
		return taskRepository.save(taskModel);
	}

	
	public List<TaskModel> listTaskModels(){
		return taskRepository.findAll();
	}
	
	
	public ResponseEntity<TaskModel> findTaskById (Long id){
		return  taskRepository.findById(id)
				.map(task -> ResponseEntity.ok().body(task))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	 public ResponseEntity<TaskModel> updateTaskById(TaskModel taskModel, Long id){
	        return taskRepository.findById(id)
	                .map(taskToUpdate ->{
	                    taskToUpdate.setTitle(taskModel.getTitle());
	                    taskToUpdate.setDescriptionTask(taskModel.getDescriptionTask());
	                    taskToUpdate.setDeadLineTask(taskModel.getDeadLineTask());
	                    TaskModel updated = taskRepository.save(taskToUpdate);
	                    return ResponseEntity.ok().body(updated);
	                }).orElse(ResponseEntity.notFound().build());
	    }

	 
	 public ResponseEntity<Object> deleteById(Long id){
		 
		 return taskRepository.findById(id)
				 .map(TaskToDelete -> {
					 taskRepository.deleteById(id);
					 return ResponseEntity.noContent().build();
				 }).orElse(ResponseEntity.notFound().build());
	 }
}






