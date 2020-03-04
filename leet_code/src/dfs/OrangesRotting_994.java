package dfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jianglei
 * @date 2020/3/4 14:02
 * <p>
 * 题号：#994. 腐烂的橘子
 * <p>
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。
 * 如果不可能，返回 -1。
 * <p>
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，
 * 因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，
 * 所以答案就是 0 。
 * <p>
 * 提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class OrangesRotting_994 {
    private static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * col + j);
                }
            }
        }
        int result = -1;
        while (!queue.isEmpty()) {
            result++;
            int curCount = queue.size();
            while (curCount > 0) {
                int curIndex = queue.poll();
                int rowIndex = curIndex / col;
                int colIndex = curIndex % col;
                if (rowIndex > 0 && grid[rowIndex - 1][colIndex] == 1) {
                    grid[rowIndex - 1][colIndex] = 2;
                    queue.add((rowIndex - 1) * col + colIndex);
                }
                if (rowIndex < row - 1 && grid[rowIndex + 1][colIndex] == 1) {
                    grid[rowIndex + 1][colIndex] = 2;
                    queue.add((rowIndex + 1) * col + colIndex);
                }
                if (colIndex > 0 && grid[rowIndex][colIndex - 1] == 1) {
                    grid[rowIndex][colIndex - 1] = 2;
                    queue.add(rowIndex * col + colIndex - 1);
                }
                if (colIndex < col - 1 && grid[rowIndex][colIndex + 1] == 1) {
                    grid[rowIndex][colIndex + 1] = 2;
                    queue.add(rowIndex * col + colIndex + 1);
                }
                curCount--;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result == -1 ? 0 : result;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int i1 = orangesRotting(grid1);
        System.out.println(i1);

        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int i2 = orangesRotting(grid2);
        System.out.println(i2);

        int[][] grid3 = {{0, 2}};
        int i3 = orangesRotting(grid3);
        System.out.println(i3);
    }
}
