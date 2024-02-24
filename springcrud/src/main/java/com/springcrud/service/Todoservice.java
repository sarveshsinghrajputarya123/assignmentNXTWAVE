/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springcrud.service;

import com.springcrud.model.TODOLIST;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author acer
 */
public interface Todoservice {
     public TODOLIST addtodo(TODOLIST todo);
    
    public String removetodo(int id);
   
    public Optional<TODOLIST> findbyid(int id);
    
    public List<TODOLIST> getalltodo();
    public String updatetodo(int id,TODOLIST todo);
}
