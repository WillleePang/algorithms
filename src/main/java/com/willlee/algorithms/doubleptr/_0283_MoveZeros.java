package com.willlee.algorithms.doubleptr;

public class _0283_MoveZeros {
    /*
     * 两个指针记录
     * 第一个index（慢指针）
     * 第二个i（快指针）
     * i照常遍历，遇到0直接跳过，遇到不为0的时候，
     * 把i的数字搬到index的位置，此时index和i之前的数字已经保证被搬过了，
     * index跳到下一格，等待新值的搬入，
     * 当i遍历到尾部的时候，表示所有的非0数字已经搬到前面了，
     * index此时的位置就是所有0的开始
     */

    public void moveZeros(int[] nums) {
        int index = 0;
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[index] = nums[i];
            index++;
        }
        for (int i = index; i < count; i++) {
            nums[i] = 0;
        }
    }
}
