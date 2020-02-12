package array;

/**
 * @author: jianglei
 * @date: 2020/2/7 23:51
 * <p>
 * 题号：#74 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，
 * 是否存在一个目标值。
 * 该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class SearchMatrix_74 {
    //解法一：暴力破解
    private static boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //解法二：二分法
    private static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mIdx = (left + right) / 2;
            int mNum = matrix[mIdx / n][mIdx % n];
            if (target < mNum) {
                right = mIdx - 1;
            } else if (target > mNum) {
                left = mIdx + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target1 = 3;
        boolean b1 = searchMatrix2(matrix, target1);
        System.out.println(b1);

        int target2 = 13;
        boolean b2 = searchMatrix2(matrix, target2);
        System.out.println(b2);
    }
}
