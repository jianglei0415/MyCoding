package array;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/10/16 23:08
 * <p>
 * 题号：#977. 有序数组的平方
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，
 * 返回每个数字的平方组成的新数组，
 * 要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class SortedSquares_977 {
    public static int[] sortedSquares(int[] A) {
        if (A == null) {
            return A;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        int[] A_1 = {-4, -1, 0, 3, 10};
        int[] ints1 = sortedSquares(A_1);
        System.out.println(Arrays.toString(ints1));

        int[] A_2 = {-7, -3, 2, 3, 11};
        int[] ints2 = sortedSquares(A_2);
        System.out.println(Arrays.toString(ints2));
    }
}
