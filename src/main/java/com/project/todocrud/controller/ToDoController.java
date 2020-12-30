package com.project.todocrud.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.todocrud.model.ToDo;
import com.project.todocrud.service.ToDoServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ToDoController {
	
	@Autowired
	ToDoServiceImpl toDoServiceImpl; 
	
	@GetMapping("/get")
	public ResponseEntity<List<ToDo>> getAllToDos() {
		return new ResponseEntity<List<ToDo>>(toDoServiceImpl.getAll(), HttpStatus.OK);
				
	}
	
	@PostMapping("/add")
	public  ResponseEntity<List<ToDo>> create(@RequestBody ToDo todo) {
		
		return new ResponseEntity<List<ToDo>>(toDoServiceImpl.add(todo), HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public String edit(@RequestBody ToDo todo){
		return toDoServiceImpl.edit(todo);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<List<ToDo>> delete(@RequestBody ToDo todo) {
		return new ResponseEntity<List<ToDo>>(toDoServiceImpl.delete(todo), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ToDo> getTodo(@PathVariable("id") String id) {
		return new ResponseEntity<ToDo>( toDoServiceImpl.getTodo(id),HttpStatus.OK);
		
	}

}