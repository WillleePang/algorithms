package com.willlee.algorithms;

import java.util.HashMap;

public class _0003_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longestNum = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, i);
            longestNum = Math.max(i - left + 1, longestNum);
        }
        return longestNum;
    }
}
