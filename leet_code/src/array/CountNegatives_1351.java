package array;

/**
 * @author jianglei
 * @date 2020/3/12 12:30
 * <p>
 * 题号：#1351. 统计有序矩阵中的负数
 * <p>
 * 给你一个 m * n 的矩阵 grid，
 * 矩阵中的元素无论是按行还是按列，
 * 都以非递增顺序排列。 
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * 示例 1：
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * <p>
 * 示例 2：
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * <p>
 * 示例 4：
 * 输入：grid = [[-1]]
 * 输出：1
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class CountNegatives_1351 {
    private static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] < 0) {
                count += (grid.length - i) * grid[0].length;
                break;
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int i1 = countNegatives(grid1);
        System.out.println(i1);

        int[][] grid2 = {{3, 2}, {1, 0}};
        int i2 = countNegatives(grid2);
        System.out.println(i2);

        int[][] grid3 = {{1, -1}, {-1, -1}};
        int i3 = countNegatives(grid3);
        System.out.println(i3);

        int[][] grid4 = {{-1}};
        int i4 = countNegatives(grid4);
        System.out.println(i4);
    }
}
