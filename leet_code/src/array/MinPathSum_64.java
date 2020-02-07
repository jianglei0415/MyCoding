package array;

/**
 * @author: jianglei
 * @date: 2020/2/7 22:20
 * <p>
 * 题号：#64 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格，
 * 请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum_64 {
    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i1 = minPathSum(grid1);
        System.out.println(i1);

        int[][] grid2 = {{1}};
        int i2 = minPathSum(grid2);
        System.out.println(i2);

        int[][] grid3 = {{1, 2}, {1, 1}};
        int i3 = minPathSum(grid3);
        System.out.println(i3);
    }
}
