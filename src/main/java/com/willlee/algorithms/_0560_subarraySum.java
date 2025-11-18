package com.willlee.algorithms;

import java.util.HashMap;

public class _0560_subarraySum {
    public static void main(String[] args) {
        subarraySum(new int[] { 2, 4, 7, 5, 3, 2, 6 }, 8);
    }

    /*
     * 
     * 前缀和 + 哈希表（最优解）
     * 这是解决此类问题的标准且高效的方法。
     * 核心思想：
     * 前缀和：我们定义一个前缀和数组 prefixSum，其中 prefixSum[i]表示从数组开头到第 i个元素（包括）的和。
     * 但实际上，我们不需要显式地存储整个前缀和数组，只需要一个变量来记录当前的前缀和即可。
     * 关键推导：一个从索引 i到 j的子数组的和可以表示为：
     * sum(i, j) = prefixSum[j] - prefixSum[i-1]
     * 我们的目标是让这个和等于 k：
     * prefixSum[j] - prefixSum[i-1] = k
     * 转换一下形式：
     * prefixSum[i-1] = prefixSum[j] - k
     * 哈希表的用途：这个转换告诉我们，对于当前的前缀和 prefixSum[j]，如果我们想知道有多少个子数组以 j结尾且和为 k，我们只需要知道在
     * j之前，有多少个位置的前缀和等于 (prefixSum[j] - k)。
     *
     * 算法步骤：
     * 初始化一个哈希表 prefix_sum_map，用于存储各个前缀和出现的次数。初始时，放入 {0: 1}，这表示前缀和为 0
     * 的情况出现了一次（即一个元素都还没取的时候）。
     * 初始化变量 current_sum = 0（当前前缀和）和 count = 0（符合条件的子数组个数）。
     * 遍历数组 nums中的每个元素 num：
     * current_sum += num（计算到当前元素为止的前缀和）。
     * 检查哈希表中是否存在键 current_sum - k。如果存在，说明我们找到了若干个以当前元素结尾的、和为 k的子数组。将对应的值（即出现次数）加到
     * count上。
     * 将 current_sum的出现次数在哈希表中加 1。
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
        HashMap<Integer, Integer> prefixHashMap = new HashMap<>();
        prefixHashMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            // 不存在以nums[i]为结尾的和为k的子数组，就把这个值设置为0，有的话就取出来
            count += prefixHashMap.getOrDefault(sums[i] - k, 0);
            prefixHashMap.put(sums[i], prefixHashMap.getOrDefault(sums[i], 0) + 1);
        }
        return count;
    }
}
