package com.example.demo.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTestingTest {
	
	
	int counter = 0;
	
	
	@BeforeAll   //it will execute before all test cases
	public static void init() {
		System.out.println("Before class ");
		System.out.println("Timing : "+ new Date());
	}
	
	
	//if you want to execute some login before each test CASE then use annotation
	
	@BeforeEach
	public void beforeEachTestcase() {
		System.out.println("before each test case ");
		counter = 0;
	}
	
	
	// if you want to execute the logic after each test case then use annotation 
	
	@AfterEach
	public void afterEachTestCase() {
		System.out.println("After each test case ");
	}
	
	
	@Test
	@DisplayName("This is custom name")
	public void addTwoSumTest() {
		
		for(int i = 0; i<=20; i++) {
			counter ++;
		}
		System.out.println("Counter : "+counter);
		System.out.println("Method Test addTwoSumTest");
		
//		  assertTimeout(Duration.ofMillis(100), () -> {
//		        Thread.sleep(2000);
//		    });

		int result = CalculatorTesting.addTwoSum(10, 20);
		
		System.out.println("Result is "+result);
		int expected = 35;
		assertEquals(expected, result);
		
		
	}
	
	@Test
	@Disabled
	public void addMultipleNumTest() {
		System.out.println("Counter : "+counter);
		System.out.println("Method Test addMultipleNumTest");
		int result = CalculatorTesting.addMultipleNum(1,2,3,4,5);
		
		System.out.println("Result is "+result);
		int exp = 15;
		assertEquals(exp, result);
	}
	
	@AfterAll    // this will execute after all cases 
	public static void cleanUp() {
		System.out.println("After All");
		System.out.println("Timing : "+ new Date());

	}

}
