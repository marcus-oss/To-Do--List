package com.treinamento.Model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
public class TaskModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id; 
	
	@Column(nullable = false)
	private String title; 
	
	@Column(nullable = false)
	private String descriptionTask; 
	
	
	@Column(nullable = false)
	private Date deadLineTask;
	
	@CreationTimestamp
	@Column(name = "created_task", nullable = false , updatable = false )
	private Date createdTask; 
	
	@UpdateTimestamp
	@Column(name = "uptade_task")
	private Date updatedTask;
	
	
}
