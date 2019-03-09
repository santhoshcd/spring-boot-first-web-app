package com.example.springbootweb.springbootfirstwebapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootweb.springbootfirstwebapp.model.Todo;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 4;

    static {
        todos.add(new Todo(1, "santy", "Learn Spring boot", new Date(),
                false));
        todos.add(new Todo(2, "santy", "Learn Microservice", new Date(), false));
        todos.add(new Todo(3, "santy", "Learn Datastructure", new Date(),
                false));
        todos.add(new Todo(4, "santy", "Learn algo and design", new Date(),
                false));
    }

    public List<Todo> all() {
        return todos;
    }

    public List<Todo> filterTodos(String todo_name) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(todo_name)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }


    public void createTodo(Todo todo) {
        todo.setId(++todoCount);
        todos.add(todo);
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Todo findById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void deleteUserById(int id) {
        Iterator<Todo> it = todos.iterator();
        while (it.hasNext()) {
            Todo todo = (Todo) it.next();
            if (todo.getId() == id) {
                it.remove();
            }
        }
    }

    public void update(Todo todo) {
        int index = todos.indexOf(todo);
        todos.set(index, todo);
    }

}