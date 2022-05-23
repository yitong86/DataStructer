package com.sophia;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalls {
        public int countBalls(int lowLimit, int highLimit) {
            Map<Integer, Integer> sumMap = new HashMap<>();
            //we create a hashmap, where our key = sumOfDigits, and value=number of times that sum occurs
            int mostBalls = 0; //initialize our variable to return
            for (int i = lowLimit; i <= highLimit; i++) {
                //lowLimit = 1, highLimit = 10
                //box number1,2,3,4,5,6,7,8,9,10
                //      sum 1,2,3,4,5,6,7,8,9,1
                //iterate over all of our limits
                int sum = 0; //we'll sum up the digits for the current number
                int currentNumber = i;//i=1
                while (currentNumber > 0) {//1 > 0
                    sum += currentNumber % 10;//sum=sum + 1 % 10 = 1
                    currentNumber /= 10;// = 1 / 10 = 0
                }
                //then put that sum back into the hashmap, and if we've already seen that sum in the hashmap, we increment the count by one
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
                //update most balls
                mostBalls = Math.max(mostBalls, sumMap.get(sum));
            }
            return mostBalls;
        }
    }
    //https://leetcode.com/problems/maximum-number-of-balls-in-a-box/