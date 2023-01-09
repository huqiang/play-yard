package qiang.hu.leetcode.solution;

import qiang.hu.leetcode.model.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class LC589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        for (Node c : node.children) {
            dfs(c, result);
        }
    }
}
