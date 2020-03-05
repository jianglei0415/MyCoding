package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianglei
 * @date 2020/3/5 14:58
 * <p>
 * 题目：#542. 01 矩阵
 * <p>
 * 给定一个由 0 和 1 组成的矩阵，
 * 找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * <p>
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * <p>
 * 注意:
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class UpdateMatrix_542 {
    private static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] flags = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int[] flag : flags) {
                int r = temp[0] + flag[0];
                int c = temp[1] + flag[1];
                if (r >= 0 && r < row && c >= 0 && c < col) {
                    if (matrix[r][c] >= matrix[temp[0]][temp[1]] + 1) {
                        matrix[r][c] = matrix[temp[0]][temp[1]] + 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] ints1 = updateMatrix(matrix1);
        System.out.println(Arrays.deepToString(ints1));

        int[][] matrix2 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints2 = updateMatrix(matrix2);
        System.out.println(Arrays.deepToString(ints2));
    }
}
