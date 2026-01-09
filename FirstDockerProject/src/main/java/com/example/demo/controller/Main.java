package com.example.demo.controller;
import java.util.*;

public class Main {

    public static int processArray(ArrayList<Integer> array) {
        int count = 0;

        boolean inOddSequence = false;
        boolean hasOddGreaterThan10 = false;

        for (int num : array) {

            if (num % 2 != 0) { 
                inOddSequence = true;

                if (num > 10) {
                    hasOddGreaterThan10 = true;
                }

            } else { 
                if (inOddSequence && hasOddGreaterThan10) {
                    count++;
                }
                inOddSequence = false;
                hasOddGreaterThan10 = false;
            }
        }

        
        if (inOddSequence && hasOddGreaterThan10) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0) {
                break;
            }
            arrayList.add(num);
        }

        int result = processArray(arrayList);
        System.out.print(result);
    }
}