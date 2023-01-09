package qiang.hu.leetcode.solution;

import qiang.hu.leetcode.model.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class LC230 {
    public int kthSmallest(TreeNode root, int k) {
        AtomicInteger counter = new AtomicInteger(0);
        return dfs(root, counter, k);
    }

    private int dfs(TreeNode node, AtomicInteger counter, int k) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left, counter, k);
        if (left != -1) {
            return left;
        }

        if (counter.incrementAndGet() == k) {
            return node.val;
        }


        int right = dfs(node.right, counter, k);
        return right;
    }

}
