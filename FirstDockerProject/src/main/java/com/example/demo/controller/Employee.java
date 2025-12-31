package com.example.demo.controller;

public class Employee implements Cloneable{
	
	private int id ;
    private String employeeName;
    
    
    public Employee(int id,String employeeName) {
    	this.id = id;
    	this.employeeName = employeeName;
    }
    
    protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	

    
    
    public static void main(String[] args) throws CloneNotSupportedException {
		
    	Employee e1 = new Employee(1,"Dash");
    	
    	Employee e2 = (Employee) e1.clone();
    	
    	System.out.println(e2.id);
	}
}
