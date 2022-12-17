package qiang.hu.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets: https://leetcode.com/problems/subsets/
 * practicing backtracking on permutation
 */
public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        int size = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>(size);
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (var i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
