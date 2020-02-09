package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/8 23:29
 * <p>
 * 题号：#85 最大矩形
 * <p>
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，
 * 找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class MaximalRectangle_85 {
    private static int maximalRectangle(char[][] matrix) {
        int result = 0;
        if (matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < m; i++) {
            int cur_left = 0;
            int cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }

    private static int maximalRectangle1(char[][] matrix) {
        int result = 0;
        if (matrix.length == 0 || matrix == null) {
            return result;
        }
        int wid = 0, len = 0;
        int[] temp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((i == 0 && matrix[i][j] == '1') || (i > 0 && ((matrix[i - 1][j] == '1' && matrix[i][j] == '1') || (matrix[i - 1][j] == '0' && matrix[i][j] == '1')))) {
                    temp[j]++;
                } else {
                    temp[j] = 0;
                }
            }
            for (int j = 0; j < temp.length; j++) {
                if (j != temp.length - 1 && temp[j] <= temp[j + 1]) {
                    continue;
                }
                wid = temp[j];
                for (int k = j; k >= 0; k--) {
                    len = j - k + 1;
                    wid = Math.min(wid, temp[k]);
                    result = Math.max(result, len * wid);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int i = maximalRectangle(matrix);
        System.out.println(i);

        int i1 = maximalRectangle1(matrix);
        System.out.println(i1);

//        char[][] matrix1 = {
//                {'0', '1'},
//                {'1', '0'}
//        };
//        int i2 = maximalRectangle1(matrix1);
//        System.out.println(i2);
    }
}
