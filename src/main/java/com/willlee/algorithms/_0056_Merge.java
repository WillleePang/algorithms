package com.willlee.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0056_Merge {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] merge = merge(intervals);
        for (int[] is : merge) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int l = intervals[0][0];
        int r = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (r < intervals[i][0]) {
                list.add(new int[] { l, r });
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                r = Math.max(r, intervals[i][1]);
            }
        }
        list.add(new int[] { l, r });

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
