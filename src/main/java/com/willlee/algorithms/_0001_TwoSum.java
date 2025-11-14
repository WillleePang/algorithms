package com.willlee.algorithms;

import java.util.HashMap;
import java.util.Map;

public class _0001_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int choose = nums[i];
            int diff = target - choose;
            if (map.containsKey(diff)) {
                return new int[] { i, map.get(diff) };
            }
            map.put(choose, i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = n - i - 1;
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            } else {
                map.put(nums[i], i);
            }
            if (map.containsKey(target - nums[j])) {
                return new int[] { map.get(target - nums[j]), j };
            } else {
                map.put(nums[j], j);
            }
        }
        return new int[0];

    }
}
