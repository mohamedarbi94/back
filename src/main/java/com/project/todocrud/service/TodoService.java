package com.project.todocrud.service;

import java.util.List;

import com.project.todocrud.model.ToDo;

public interface TodoService {
	
	
	 List<ToDo> getAll();
	 ToDo getTodo(String id) ;
	 List<ToDo> add(ToDo todo) ;
	 String edit(ToDo todo) ;
	 List<ToDo> delete(ToDo ToDo) ;
}
