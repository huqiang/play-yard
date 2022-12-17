package qiang.hu.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combinations: https://leetcode.com/problems/combinations/
 * practicing backtracking
 */
public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        backtracking(n, k, 0, new ArrayList<>(k), result);
        return result;
    }

    private void backtracking(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (var i = start; i <= n; i++) {
            current.add(i);
            backtracking(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
