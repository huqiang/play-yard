package qiang.hu.leetcode.solution;

import qiang.hu.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * BFS to iterate the tree level by level.
 */
public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            List<Integer> level = new ArrayList<>();
            result.add(level);
            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
