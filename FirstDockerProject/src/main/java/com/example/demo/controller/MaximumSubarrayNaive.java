package com.example.demo.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MaximumSubarrayNaive  {


	public static void main(String[] args) {
		
	  
	  String[] chas = str.toLowerCase().split("");
	  
	   System.out.println(Arrays.stream(chas).collect(Collectors.groupingBy(v -> v ,LinkedHashMap :: new, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get());
	   
	   
	   
	   
	    map.chars().mapToObj(l -> (char) l).distinct().forEach(ch -> System.out.print(ch));
	   
	    String s = "Hello this is Hello";
//	    String[] ch = s.split(" ");
	    
//	    Arrays.stream(ch).collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).forEach(System.out::println);;
	    
	    
	    
	    
	    
	    
	   
	    String[] ch = s.split(" ");
	    
	    
	    Arrays.stream(ch).collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().sorted(Comparator.comparing(entry -> entry.getValue()).reversed()).forEach(System.out::println);
	    

	   
	   
	   
	   
	   
	  
	 
	
	}
}
