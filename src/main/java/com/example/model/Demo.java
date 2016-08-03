package com.example.model;

import javax.persistence.*;

@Entity
@Table( name = "demo" )
public class Demo{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private long id;
    private String name;
    
    public Demo(){
    	
    }
    
    public Demo(String name){
    	this.name = name;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
}