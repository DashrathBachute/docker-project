package com.example.demo.controller;

import java.util.function.Supplier;

public class Supplaers {

	
	public static void main(String[] args) {
		
		Supplier<String> supplier = () ->"Hello Dash";
		
		System.out.println(supplier.get());
	}
}
