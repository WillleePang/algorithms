package com.willlee.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0239_maxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] result = maxSlidingWindow(nums, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int windowStart = i - k + 1;
            // 移除刚好离开窗口的元素
            if (!deque.isEmpty() && deque.peekFirst() < windowStart - 1) {
                deque.pollFirst();
            }
            // 维护单调递减性
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 当窗口形成时记录结果
            deque.offerLast(i);
            if (i >= k - 1) {
                result[idx++] = nums[deque.peekFirst()];
            }
        }
        return result;

    }
}
