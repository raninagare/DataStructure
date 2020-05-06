package com.ds.rani.hashing;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
//Approach: Use hashmap to store number,integer. Compute the complemet(target-number) and check if that is available in map
//If it is available then return current index and the index available in map for complemnt.
public class TwoSum {
    /**
     * @param nums   array
     * @param target value
     * @return arry of size 2 containing indices of elemts whose sum ==target
     */

    //Time complexity:o(n): where n is input array size
    //space complexity;o(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        //Traverse over input array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey( complement )) {
                result[0] = i;
                result[1] = map.get( complement );
                return result;
            } else
                map.put( nums[i], i );
        }
        return result;
    }
}
