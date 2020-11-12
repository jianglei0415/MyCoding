package array;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/11/12 17:38
 * <p>
 * 题号：#922. 按奇偶排序数组 II
 * <p>
 * 给定一个非负整数数组 A，
 * A 中一半整数是奇数，
 * 一半整数是偶数。
 * 对数组进行排序，
 * 以便当 A[i] 为奇数时，i 也是奇数；
 * 当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII_922 {
    public static int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        int[] ints = sortArrayByParityII(A);
        System.out.println(Arrays.toString(ints));
    }
}
