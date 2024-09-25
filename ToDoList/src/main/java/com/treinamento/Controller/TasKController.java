package com.treinamento.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.Model.TaskModel;
import com.treinamento.Service.TaskServices;

import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/api/todo")
@AllArgsConstructor
@Slf4j
public class TasKController {

	@Autowired
	TaskServices taskServices;
	
	
	

	@PostMapping("/tasks")
	@ResponseStatus(HttpStatus.CREATED)
	public TaskModel createdTask(@RequestBody TaskModel taskModel ) {
	log.info("criando uma nova task com informações[{}] ",taskModel);
		return taskServices.createTask(taskModel);
	}
	
	@GetMapping("tasks")
	@ResponseStatus(HttpStatus.OK)
	public List<TaskModel> getAllTask(){
		log.info("listando todas as task");
		return  taskServices.listTaskModels();
	}
	
	@GetMapping("tasks/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TaskModel> getTaskById(@PathVariable (value = "id") Long Id){
	log.info("Buscando uma task com Id{[]}",Id);
		return  taskServices.findTaskById(Id);
	}

	
	
	@PutMapping("tasks/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TaskModel> getUpdtedById(@PathVariable (value = "id") Long Id,@RequestBody TaskModel taskModel){
		log.info("atualizando uma task [{}] ",taskModel);
		return  taskServices.updateTaskById(taskModel,Id);
	}
	

	
	@DeleteMapping("/tasks/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long Id){
		log.info("deletando uma task com Id [{}]");
		return  taskServices.deleteById(Id);
	}

}
	

