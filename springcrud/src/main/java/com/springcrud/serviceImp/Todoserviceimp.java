/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springcrud.serviceImp;

import com.springcrud.model.TODOLIST;
import com.springcrud.repository.TodoRepository;
import com.springcrud.service.Todoservice;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Todoserviceimp implements Todoservice {
@Autowired
    private TodoRepository todorepo;
    
    
    @Override
    public TODOLIST addtodo(TODOLIST todo) {
        TODOLIST  emp=   todorepo.save(todo);
        return emp;
    }

    @Override
    public String removetodo(int id) {
         todorepo.deleteById(id);
       return "delete data successsfully";
        
    }

    @Override
    public Optional<TODOLIST> findbyid(int id) {
         Optional<TODOLIST> emp=  todorepo.findById(id);
        if(emp.isPresent()){
            return emp;
        }else{
         return null;   
        }
    }

    @Override
    public List<TODOLIST> getalltodo() {
         List<TODOLIST> todolist =todorepo.findAll();
        return todolist;
    }

    @Override
    public String updatetodo(int id, TODOLIST tod) {
         Optional<TODOLIST> emp=todorepo.findById(id);
        if(emp.isPresent()){
            TODOLIST exittodo=emp.get();
          exittodo.setTodo(tod.getTodo());
          exittodo.setStatus(tod.getStatus());
          exittodo.setPriority(tod.getPriority());
          
          
            todorepo.save(exittodo);
            
            
            
            return "update  sucessfully";
        }
        else{
            
            return "todo not found";
        }
    }
    
    }
    

