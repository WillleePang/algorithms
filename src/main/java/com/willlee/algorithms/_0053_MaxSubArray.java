package com.willlee.algorithms;

public class _0053_MaxSubArray {

    /*
     * 
     * nums[i] 和 sum[i-1]的关系；
     * 如果sum[i-1]是正数，那么sum[i] = sum[i-1] + nums[i] 肯定会大于nums[i]
     * 如果sum[i-1]是负数，那么sum[i] = sum[i-1] + nums[i] 肯定会小于nums[i]
     * 所以我们只要看sum[i-1]的正负就好了，正数就直接加上，负数就返回nums[i]跟maxnum做对比就好
     */
    public static int maxSubArray(int[] nums) {
        int maxnum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > maxnum) {
                maxnum = sum;
            }
        }
        return maxnum;
    }
}
