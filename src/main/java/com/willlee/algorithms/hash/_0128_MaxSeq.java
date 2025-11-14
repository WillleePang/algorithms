package com.willlee.algorithms.hash;

import java.util.HashSet;

public class _0128_MaxSeq {
    /*
     * 头：前面没有前置数字
     * 中：该数字存在后续数字
     * 尾：后面没有后续数字
     * 
     * 找到头节点，开始遍历，
     * 如果下一个有后续数字，那么为中部节点，继续遍历，
     * 如果下一个没有后续数字，那么为尾树，返回整个序列。
     */

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = 1;
            int tempNum = nums[i];
            // not charge the num is head or not
            while (map.contains(++tempNum)) {
                tempMax++;
            }
            maxNum = Math.max(maxNum, tempMax);
        }
        return maxNum;
    }

    public static int longestConsecutive1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        int count = 0;
        for (int n : set) {
            // head num
            if (!set.contains(n - 1)) {
                count = 1;
                int currNum = n;
                while (set.contains(++currNum)) {
                    count++;
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }
}
