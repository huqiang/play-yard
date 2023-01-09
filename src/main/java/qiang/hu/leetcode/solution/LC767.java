package qiang.hu.leetcode.solution;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 */
public class LC767 {
    /**
     * Implement with priority queue;
     *
     * @param args
     */

    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            if (count > max) {
                max = count;
            }
        }
        if (max > (s.length() + 1) >> 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.length());
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(map.size(), (o1, o2) -> (int) o2.getValue() - (int) o1.getValue());
        pq.addAll(map.entrySet());
        char prev = 0;
        while (sb.length() < s.length()) {
            if (pq.peek().getKey() != prev) {
                Map.Entry<Character, Integer> entry = pq.poll();
                sb.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() > 0) {
                    pq.add(entry);
                }
                prev = entry.getKey();
            } else {
                Map.Entry<Character, Integer> entry = pq.poll();
                Map.Entry<Character, Integer> entry2 = pq.poll();
                sb.append(entry2.getKey());
                entry2.setValue(entry2.getValue() - 1);
                if (entry2.getValue() > 0) {
                    pq.add(entry2);
                }
                pq.add(entry);
                prev = entry2.getKey();
            }
        }
        return sb.toString();
    }

    /*
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            if (count > max) {
                max = count;
            }
        }
        if (max > (s.length() + 1) >> 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.length());
        char prev = 0;
        char c;
        while (sb.length() < s.length()) {
            c = findMax(map, prev);
            sb.append(c);
            prev = c;
            map.put(c, map.get(c) - 1);
        }
        return sb.toString();
    }

    private char findMax(Map<Character, Integer> map, char prev) {
        int max = 0;
        char c = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max && entry.getKey() != prev) {
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        return c;
    }
     */

    public static void main(String[] args) {
        LC767 lc767 = new LC767();
        System.out.println(lc767.reorganizeString("aab"));
        System.out.println(lc767.reorganizeString("aaab"));
    }
}
