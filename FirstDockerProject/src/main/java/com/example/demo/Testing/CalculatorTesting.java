package com.example.demo.Testing;

public class CalculatorTesting {
	
	
	public static int addTwoSum(int a, int b) {
		return a+b;
	}
	
	public static int addMultipleNum(int... number) {
		int s = 0;
		for (int num : number) {
			s = s + num;
		}
		return s;
	}

}
