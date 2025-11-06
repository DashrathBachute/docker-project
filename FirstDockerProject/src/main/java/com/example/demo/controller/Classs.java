package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Classs {
	
	public static void main(String[] args) {
		
		int[]arr = {1,2,6,2,4,1,5,6,8};
		
		//find out the duplicate elements from the list 
		
		List<Integer> dup =  IntStream.of(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry :: getKey).collect(Collectors.toList());
		System.out.println(dup);
		


	}
 
}
