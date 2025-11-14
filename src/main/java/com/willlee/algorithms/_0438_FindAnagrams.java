package com.willlee.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return null;
        }

        Word word = new Word(p);

        for (int left = 0; left < sLength; left++) {
            int right = left + pLength - 1;
            if (right > s.length() - 1) {
                break;
            }
            Word temp = new Word(s.substring(left, right + 1));
            if (word.equals(temp)) {
                res.add(left);
            }
        }
        return res;
    }

    class Word {
        int[] counts;

        Word(String s) {
            char[] charArray = s.toCharArray();
            counts = new int[26];
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                counts[c - 'a']++;
            }
        }

        public boolean equals(Object o) {
            return Arrays.equals(counts, ((Word) o).counts);
        }

        public int hashCode() {
            return Arrays.hashCode(counts);
        }
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>(); // 存储结果：异位词的起始索引

        char[] ch = s.toCharArray(); // s 转字符数组，方便按索引取字符
        int len = s.length(); // s 的长度
        int[] count = new int[26]; // 字符计数数组：count[i] 对应 'a'+i 字符的数量

        // 第一步：初始化计数数组，统计 p 中每个字符的数量
        for (int i = 0; i < p.length(); i++) {
            // p.charAt(i) - 'a'：将字符转为 0-25 的索引（如 'a'→0，'b'→1）
            count[p.charAt(i) - 'a'] += 1;
        }

        int left = 0; // 滑动窗口左边界（起始为 0）
        // 第二步：右边界 right 遍历 s，扩大窗口
        for (int right = 0; right < len; right++) {
            // 1. 把当前右边界的字符加入窗口：计数数组中对应字符的数量减 1
            // （核心逻辑：count 初始是 p 的字符计数，窗口内的字符会抵消计数，最终全为 0 则匹配）
            count[ch[right] - 'a']--;

            // 2. 关键：如果当前字符的计数 < 0，说明窗口内该字符数量超过了 p 中的数量
            // 必须移动左边界，缩小窗口，直到该字符计数 ≥ 0（窗口内字符数量不超标）
            while (count[ch[right] - 'a'] < 0) {
                count[ch[left] - 'a']++; // 左边界字符移出窗口，计数加回 1
                left++; // 左边界右移，缩小窗口
            }

            // 3. 当窗口长度 == p 的长度时，说明窗口内字符计数与 p 完全匹配（全为 0）
            // 此时 left 就是异位词的起始索引，加入结果集
            if (right - left + 1 == p.length()) {
                res.add(left);
            }
        }

        return res;
    }
}
