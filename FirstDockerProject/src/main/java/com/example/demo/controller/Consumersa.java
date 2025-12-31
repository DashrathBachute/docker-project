package com.example.demo.controller;

import java.util.Arrays;

public class Consumersa {
	
	
	public static void main(String[] args) {
		
		 int[] a = {1, 3, 5, 7};
	     int[] b = {2, 4, 6, 8};
	     
	     
	     int[] merged = new int[a.length + b.length];
	     
	     int index = 0;
	     
	     for(int i = 0; i<a.length; i++) {
	    	 merged[index++]= a[i];
	     }
	     
	     for(int j = 0 ; j<b.length;j++) {
	    	 merged[index++] = b[j];
	     }
	     
	     System.out.println(Arrays.toString(merged));
	     
	     
	     for(int i = 0; i< merged.length;i++) {
	    	 for(int j = i+1; j<merged.length ; j++) {
	    		 if(merged[i] > merged[j]) {
	    			 int temp = merged[i];
	    			 merged[i] = merged[j];
	    			 merged[j] = temp;
	    		 }
	    	 }
	     }
	     
	     System.out.println(Arrays.toString(merged));
	     
	}

}
