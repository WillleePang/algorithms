public class __0076_minWindow {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int[] tChars = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tChars[t.charAt(i)]++;
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int size = Integer.MAX_VALUE;
        int count = t.length();
        while (right < s.length()) {
            if (tChars[s.charAt(right)] > 0) {
                count--;
            }
            tChars[s.charAt(right)]--;
            if (count == 0) {
                while (left < right && tChars[s.charAt(left)] < 0) {
                    tChars[s.charAt(left)]++;
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                tChars[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
