/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springcrud.controller;

import com.springcrud.model.TODOLIST;
import com.springcrud.serviceImp.Todoserviceimp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@RestController
public class TodoController {
    
    
      @Autowired
     private Todoserviceimp todoseri;
    
    
    @PostMapping("/todos")
    public ResponseEntity<TODOLIST> addTodo(@RequestBody TODOLIST todo){
        TODOLIST emp=todoseri.addtodo(todo);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> removeTodolist(@PathVariable int id){
        todoseri.removetodo(id);
        return new ResponseEntity<>("remove sucess",HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/todos/{id}")
     public ResponseEntity<Optional<TODOLIST>> findtodoid(@PathVariable int id){
         Optional<TODOLIST> emps=todoseri.findbyid(id);
         return new ResponseEntity<>(emps,HttpStatus.ACCEPTED);
     }
     
     @GetMapping("/todos")
     public ResponseEntity<List<TODOLIST>> listoftodo(){ 
         List<TODOLIST> ltodo=todoseri.getalltodo();
         return new ResponseEntity<>(ltodo,HttpStatus.ACCEPTED);
     }
     
     @PutMapping("/todos/{id}")
     public ResponseEntity<String> updateetodo(@PathVariable int id,@RequestBody TODOLIST tod ){
        String a= todoseri.updatetodo(id, tod);
        return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
     }
}
