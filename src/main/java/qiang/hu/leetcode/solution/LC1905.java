package qiang.hu.leetcode.solution;

/**
 * https://leetcode.com/problems/count-sub-islands/
 */
public class LC1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && !visited[i][j] && dfs(i, j, grid1, grid2, visited)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int r, int c, int[][] grid1, int[][] grid2, boolean[][] visited) {
        if (r < 0 || r >= grid2.length || c < 0 || c >= grid2[0].length || grid2[r][c] == 0 || visited[r][c]) {
            return true;
        }

        visited[r][c] = true;

        // DONT use && operator here, because we need to check all the neighbors
        boolean result = grid1[r][c] == 1;
        result &= dfs(r - 1, c, grid1, grid2, visited);
        result &= dfs(r + 1, c, grid1, grid2, visited);
        result &= dfs(r, c - 1, grid1, grid2, visited);
        result &= dfs(r, c + 1, grid1, grid2, visited);
//        System.out.println(Arrays.asList(r, c, result));
        return result;
    }

    public static void main(String[] args) {
        LC1905 lc1905 = new LC1905();
        System.out.println(lc1905.countSubIslands(new int[][]{{1, 1, 1, 0, 0},
                        {0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1}},
                new int[][]{{1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1},
                        {0, 1, 0, 0, 0},
                        {1, 0, 1, 1, 0},
                        {0, 1, 0, 1, 0}}));
    }
}
