package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;
import com.acme.todolist.domain.TodoItem;

public class TodolistTestsU {

	static final String LATE = "[LATE!] ";
	
	@Test
	public void testTodoIsLate_finalContent() {
	Instant past = Instant.now().minus(Duration.ofDays(2));
		TodoItem todo = new TodoItem("5", past, "exemple exo 3 - tu1");    //TODO
		assertTrue(todo.finalContent().contains(LATE));
	}

	@Test
	public void testTodoIsNotLate_finalContent() {
	Instant past = Instant.now().minus(Duration.ofDays(2));
		TodoItem todo = new TodoItem("10", past, "exemple exo 3 - tu2");    //TODO
		assertTrue(todo.finalContent().contains(LATE));
	}
}
