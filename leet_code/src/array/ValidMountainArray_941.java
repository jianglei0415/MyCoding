package array;

/**
 * @author jianglei
 * @date 2020/11/3 18:04
 * <p>
 * 题号：#941. 有效的山脉数组
 * <p>
 * 给定一个整数数组 A，
 * 如果它是有效的山脉数组就返回 true，
 * 否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，
 * 那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 示例 1：
 * 输入：[2,1]
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：[3,5,5]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：[0,3,2,1]
 * 输出：true
 * <p>
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 */
public class ValidMountainArray_941 {
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int i = 0, j = A.length;
        while (i + 1 < j && A[i] < A[i + 1]) {
            i++;
        }

        if (i == 0 || i == j - 1) {
            return false;
        }

        while (i + 1 < j && A[i] > A[i + 1]) {
            i++;
        }

        return i == j - 1;
    }

    public static void main(String[] args) {
        int[] A_1 = {2, 1};
        boolean b1 = validMountainArray(A_1);
        System.out.println(b1);

        int[] A_2 = {3, 5, 5};
        boolean b2 = validMountainArray(A_2);
        System.out.println(b2);

        int[] A_3 = {0, 3, 2, 1};
        boolean b3 = validMountainArray(A_3);
        System.out.println(b3);
    }
}
