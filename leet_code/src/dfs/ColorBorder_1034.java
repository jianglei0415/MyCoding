package dfs;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/10/30 18:56
 * <p>
 * 题号：#1034. 边框着色
 * <p>
 * 给出一个二维整数网格 grid，
 * 网格中的每个值表示该位置处的网格块的颜色。
 * 只有当两个网格块的颜色相同，
 * 而且在四个方向中任意一个方向上相邻时，
 * 它们属于同一连通分量。
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，
 * 或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 * 给出位于 (r0, c0) 的网格块和颜色 color，
 * 使用指定颜色 color 为所给网格块的连通分量的边界进行着色，
 * 并返回最终的网格 grid 。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * <p>
 * 示例 2：
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * <p>
 * 示例 3：
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 * <p>
 * 提示：
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 */
public class ColorBorder_1034 {
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int oldColor = grid[r0][c0];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0, oldColor, color, visited);
        return grid;
    }

    private static void dfs(int[][] grid, int x, int y, int oldColor, int newColor, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }

        if (visited[x][y] || grid[x][y] != oldColor) {
            return;
        }

        if (x == 0 || y == 0 || x == grid.length - 1 || y == grid[0].length - 1) {
            grid[x][y] = newColor;
        } else {
            if (x >= 1 && grid[x - 1][y] != oldColor && visited[x - 1][y] == false) {
                grid[x][y] = newColor;
            }
            if (y >= 1 && grid[x][y - 1] != oldColor && visited[x][y - 1] == false) {
                grid[x][y] = newColor;
            }
            if (x < grid.length - 1 && grid[x + 1][y] != oldColor && visited[x + 1][y] == false) {
                grid[x][y] = newColor;
            }
            if (y < grid[0].length && grid[x][y + 1] != oldColor && visited[x][y + 1] == false) {
                grid[x][y] = newColor;
            }
        }
        visited[x][y] = true;

        dfs(grid, x - 1, y, oldColor, newColor, visited);
        dfs(grid, x + 1, y, oldColor, newColor, visited);
        dfs(grid, x, y - 1, oldColor, newColor, visited);
        dfs(grid, x, y + 1, oldColor, newColor, visited);
    }

    public static void main(String[] args) {
        int[][] grid_1 = {
                {1, 1},
                {1, 2}
        };
        int r0_1 = 0, c0_1 = 0, color_1 = 3;
        int[][] ints_1 = colorBorder(grid_1, r0_1, c0_1, color_1);
        System.out.println(Arrays.deepToString(ints_1));

        int[][] grid_2 = {
                {1, 2, 2},
                {2, 3, 2}
        };
        int r0_2 = 0, c0_2 = 1, color_2 = 3;
        int[][] ints_2 = colorBorder(grid_2, r0_2, c0_2, color_2);
        System.out.println(Arrays.deepToString(ints_2));

        int[][] grid_3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        int r0_3 = 1, c0_3 = 1, color_3 = 2;
        int[][] ints_3 = colorBorder(grid_3, r0_3, c0_3, color_3);
        System.out.println(Arrays.deepToString(ints_3));
    }
}
