package com.willlee.algorithms.doubleptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {

            //因为是有序数组，所以如果两个数相等，那么其他的结果集肯定也一样
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int r = n - 1;
            int target = -nums[i];
            //双指针循环，从目标数字后一位的子数组开始双循环
            for (int l = i + 1; l < r; l++) {
                //依旧去重操作
                if (l != i + 1 && nums[l] == nums[l - 1]) {
                    continue;
                }
                //检查子数组末尾数字是不是大于，大于的话，末尾指针向前走
                //还有可能找到结果集，因为数组排序好了，前面的是小的数字
                while (nums[l] + nums[r] > target && r > l) {
                    r--;
                }
                if (l == r) {
                    break;
                }
                if (nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
