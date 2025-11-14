package com.willlee.algorithms.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Word, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Word word = new Word(str);
            List<String> mapList = map.getOrDefault(word, new ArrayList<String>());
            mapList.add(str);
            map.put(word, mapList);
        }
        return new ArrayList<List<String>>(map.values());
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
}