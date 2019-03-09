package com.example.springbootweb.springbootfirstwebapp;

import com.example.springbootweb.springbootfirstwebapp.model.Todo;
import com.example.springbootweb.springbootfirstwebapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class TodoController {

    @Autowired
    TodoService todoService;
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> index(){
        List<Todo> todos = todoService.all();
        return todos;
    }

    @PostMapping(value="",headers="Accept=application/json")
    public ResponseEntity<Todo> create(@Valid @RequestBody Todo todo, BindingResult result){
        System.out.println(result.hasErrors());
        if(result.hasErrors()){
            return new ResponseEntity<Todo>(HttpStatus.BAD_REQUEST);
        }
        todoService.createTodo(todo);
        return new ResponseEntity<Todo>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> show(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Todo todo = todoService.findById(id);
        if (todo == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    @PutMapping(value="/{id}", headers="Accept=application/json")
    public ResponseEntity<Todo> updateUser(@PathVariable("id") int id, @RequestBody Todo todo)
    {
        Todo currentTodo = todoService.findById(id);
        if (currentTodo == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }
        currentTodo.setId(id);
        currentTodo.setUser(todo.getUser());
        currentTodo.setDesc(todo.getDesc());
        currentTodo.setTargetDate(todo.getTargetDate());
        currentTodo.setDone(todo.isDone());
        todoService.update(currentTodo);
        return new ResponseEntity<Todo>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Todo> delete(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Todo todo = todoService.findById(id);
        if (todo == null) {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }
        todoService.deleteUserById(id);
        return new ResponseEntity<Todo>(HttpStatus.NO_CONTENT);
    }
}
