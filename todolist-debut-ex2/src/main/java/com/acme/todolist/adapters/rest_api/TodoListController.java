package com.acme.todolist.adapters.rest_api;

import java.util.List;
 
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.application.service.GetTodoItemsService;
import com.acme.todolist.application.port.in.AddTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQueryService;
	private AddTodoItems addTodoItemsQuery;
	
	
	@Inject
	public TodoListController(GetTodoItemsService getTodoItemsQueryService, AddTodoItems addTodoItemsQuery,) {
		this.getTodoItemsQueryService = getTodoItemsQueryService;
		this.addTodoItemsQuery = addTodoItemsQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQueryService.getAllTodoItems();
	}
	
	
	@PostMapping("/todos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createTodoItem(@RequestBody TodoItem todoItem) {
		addTodoItemsQuery.addTodoItem(todoItem);
	}
	
}
