package qiang.hu.leetcode.solution;

import qiang.hu.leetcode.model.Node;
import qiang.hu.leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class LC559 {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int max = 0;
        for(Node c: root.children){
            max = Math.max(max, maxDepth(c));
        }
        return max + 1;
    }
}
