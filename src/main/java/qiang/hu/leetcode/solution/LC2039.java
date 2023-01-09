package qiang.hu.leetcode.solution;

import java.util.*;

/**
 * https://leetcode.com/problems/the-time-when-the-network-becomes-idle/description/
 */
public class LC2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] distance = new int[patience.length];

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
//                System.out.println(size);
                Integer curr = queue.poll();
                int dis = distance[curr] + 2;
                for (Integer next : graph.get(curr)) {
                    if (distance[next] == 0) {
                        distance[next] = dis;
                        queue.add(next);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i < patience.length; i++) {
            max = Math.max(max, (distance[i] - 1) / patience[i] * patience[i] + distance[i]);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        int[] patience = new int[]{0, 10, 10};
        System.out.println(new LC2039().networkBecomesIdle(edges, patience));
    }
}
