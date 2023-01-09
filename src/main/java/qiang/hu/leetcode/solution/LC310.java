package qiang.hu.leetcode.solution;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/description/
 */
public class LC310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>(n);
        int remaining = n;
        for (int i = 0; i < n; i++) {
            if (graph.get(i) == null || graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>(remaining);
            for (int leaf : leaves) {
                int parent = graph.get(leaf).iterator().next();
                graph.get(parent).remove(leaf);
                if (graph.get(parent).size() == 1) {
                    newLeaves.add(parent);
                }
                graph.remove(leaf);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        LC310 lc310 = new LC310();
        // [[1,0],[1,2],[1,3]]
        System.out.println(lc310.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }
}
