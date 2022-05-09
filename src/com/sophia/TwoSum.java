package com.sophia;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            //target = nums[index1] + nums[index2]
            Map<Integer,Integer> num_map = new HashMap<>();
            //{key=nums[i],value=index}
            //{2:0} {7:1} {11:2} {15:3}
            //return [index1,index2]
            int[] result = new int[2];
            ////nums = [2,7,11,15] target = 9
            for(int i = 0; i < nums.length;i++){
                int complement = target - nums[i];
                // not use the same element twice.
                if(num_map.containsKey(complement) && num_map.get(complement) != i){
                    result[0] = i;
                    result[1] = num_map.get(complement);
                }else{
                    num_map.put(nums[i],i);
                }

            }

            return result;
        }
    }


