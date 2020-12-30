package com.project.todocrud.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.project.todocrud.model.ToDo;

@Service
public class ToDoServiceImpl implements TodoService {

	
	 List<ToDo> todos = new ArrayList<ToDo>();
	
	 
	 
	@Override
	public  List<ToDo> add(ToDo todo) {
		 todos.add(todo);
		return  todos;
		  
	}
	@Override
	public String edit(ToDo todo) {
		todos.stream().filter(t -> t.getId().equals(todo.getId())).forEach(t -> 
		{
			
			t.setDescription(todo.getDescription());
		}
				);
		return "Successfully updated !";
	}
	
	@Override
	public List<ToDo> delete(ToDo todo) {
		todos.removeIf(element->element.equals(todo));
		return todos;
	}
	
	@Override
	public List<ToDo> getAll() {
		return todos;
	}
	@Override
	public ToDo getTodo(String id){
		
		return todos.stream().filter(e -> e.getId().equals(id)).findFirst().get();
	}
	
	
}
