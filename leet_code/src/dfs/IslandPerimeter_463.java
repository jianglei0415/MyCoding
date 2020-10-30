package dfs;

/**
 * @author jianglei
 * @date 2020/8/16 18:15
 * <p>
 * 题号；#463 岛屿的周长
 * <p>
 * 给定一个包含 0 和 1 的二维网格地图，
 * 其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。
 * 网格为长方形，且宽度和高度均不超过 100 。
 * 计算这个岛屿的周长。
 * <p>
 * 示例 :
 * 输入:
 * [
 * [0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]
 * ]
 * 输出: 16
 */
public class IslandPerimeter_463 {
    public static int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }

        if (grid[i][j] == 0) {
            return 1;
        }

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }

    public static int islandPerimeter2(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        result++;
                    }
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        result++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        result++;
                    }
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int i = islandPerimeter(grid);
        System.out.println(i);

        int[][] grid_2 = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int i2 = islandPerimeter2(grid_2);
        System.out.println(i2);
    }
}
