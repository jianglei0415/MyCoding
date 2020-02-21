package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/2/21 23:22
 * <p>
 * 剑指offer系列
 * <p>
 * 题号：面试题29 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，
 * 按照从外向里以顺时针的顺序依次打印出每一个数字。
 *  
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralOrder_29 {
    private static int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int count = (Math.min(m, n) + 1) / 2;
        int i = 0;
        while (i < count) {
            for (int j = i; j < n - i; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i + 1; j < m - i; j++) {
                result.add(matrix[j][n - 1 - i]);
            }
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i) != i; j--) {
                result.add(matrix[m - 1 - i][j]);
            }
            for (int j = (m - 1) - (i + 1); j > i && (n - 1 - i) != i; j--) {
                result.add(matrix[j][i]);
            }
            i++;
        }
        int[] res = new int[result.size()];
        int tep = 0;
        for (int i1 : result) {
            res[tep++] = i1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints1 = spiralOrder(matrix1);
        System.out.println(Arrays.toString(ints1));

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] ints2 = spiralOrder(matrix2);
        System.out.println(Arrays.toString(ints2));
    }
}
