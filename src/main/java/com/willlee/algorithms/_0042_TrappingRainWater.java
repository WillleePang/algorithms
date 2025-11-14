package com.willlee.algorithms;

import java.util.Stack;

public class _0042_TrappingRainWater {
    public static int trapWater(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int total = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int width = i - left - 1;
                total += width * (Math.min(height[stack.peek()], height[i]) - height[cur]);
            }
            stack.push(i);
        }
        return total;
    }
}
