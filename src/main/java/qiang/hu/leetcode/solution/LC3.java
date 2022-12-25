package qiang.hu.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            Character rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                max = Math.max(max, right - left);
                left = Math.max(left, map.get(rightChar) + 1);
            }
            map.put(rightChar, right);
            right++;
        }
        return Math.max(max, right - left);
    }

    public static void main(String[] args) {
        LC3 lc3 = new LC3();
        System.out.println(lc3.lengthOfLongestSubstring("abba"));
        System.out.println(lc3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lc3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lc3.lengthOfLongestSubstring(" "));
        System.out.println(lc3.lengthOfLongestSubstring("au"));
        System.out.println(lc3.lengthOfLongestSubstring("dvdf"));
    }
}
