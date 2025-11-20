package com.willlee.algorithms;

public class _189_Rotate {

    public void rotate(int[] nums, int k) {
        int step = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, step - 1);
        reverse(nums, step, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
