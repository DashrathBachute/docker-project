package com.example.demo.controller;

public class MaximumSubarrayNaive {

	public static void main(String[] args) {
		
		
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int k = 4;
        System.out.println("Maximum Subarray Sum = " + maxSubArray(arr,k));


        
		

	}

	private static int maxSubArray(int[] arr,int k) {
		int n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		int windowSum = 0;
		
		
		for(int i = 0; i<k ; i++) {
			windowSum = windowSum + arr[i];
		}
		
		maxSum = windowSum;
		
		
		for(int i = k; i< n; i++) {
			windowSum = windowSum + arr[i]-arr[i-k];
			maxSum = Math.max(maxSum, windowSum);
		}
		
		return maxSum;
		
	}

}
