package com.willlee.algorithms.doubleptr;

/*
 * 两边往中间移动，寻找更大的面积，
 * 看哪个边短，就继续遍历寻找。
 * 
 */
public class _0011_MaxArea {
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(area, res);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public int maxArea1(int[] height) {
        int lMax = height[0];
        int rMax = height[height.length - 1];
        int i = 0;
        int j = height.length - 1;
        int ans = (height.length - 1) * Math.min(lMax, rMax);
        while (i < j) {
            if (lMax < rMax) {
                while (i < j && height[i] <= lMax) {
                    i++;
                }
                lMax = height[i];
                ans = Math.max(ans, (j - i) * Math.min(lMax, rMax));
            } else if (lMax > rMax) {
                while (i < j && height[j] <= rMax) {
                    j--;
                }
                rMax = height[j];
                ans = Math.max(ans, (j - i) * Math.min(lMax, rMax));
            } else {
                while (i < j && height[i] <= lMax) {
                    i++;
                }
                lMax = height[i];
                while (i < j && height[j] <= rMax) {
                    j--;
                }
                rMax = height[j];
                ans = Math.max(ans, (j - i) * Math.min(lMax, rMax));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
    }
}
