package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/6 23:37
 * <p>
 * 题号：#54 螺旋矩阵
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），
 * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder_54 {
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null||matrix[0]==null) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int count = (Math.min(m, n) + 1) / 2;
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
            for (int j = (m - 1) - (i + 1); j > i && (n - i - i) != i; j--) {
                result.add(matrix[j][i]);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list1 = spiralOrder(matrix1);
        System.out.println(list1);

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list2 = spiralOrder(matrix2);
        System.out.println(list2);
    }
}
