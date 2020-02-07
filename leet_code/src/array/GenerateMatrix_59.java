package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/7 17:26
 * <p>
 * 题号：#59 螺旋矩阵II
 * <p>
 * 给定一个正整数 n，
 * 生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrix_59 {
    private static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = (n + 1) / 2;
        int a = 0;
        int temp = 0;
        while (a < count) {
            for (int i = a; i < n - a; i++) {
                result[a][i] = ++temp;
            }
            for (int i = a + 1; i < n - a; i++) {
                result[i][n - 1 - a] = ++temp;
            }
            for (int i = n - 1 - a - 1; i >= a + 1 && (n - a) != a; i--) {
                result[n - 1 - a][i] = ++temp;
            }
            for (int i = n - 1 - a; i >= a + 1 && (n - a) != a; i--) {
                result[i][a] = ++temp;
            }
            a++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] ints = generateMatrix(n);
        System.out.println(Arrays.deepToString(ints));
    }
}
