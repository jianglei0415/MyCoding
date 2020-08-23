package math;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/8/23 16:51
 * <p>
 * 题号：#910. 最小差值 II
 * <p>
 * 给定一个整数数组 A，
 * 对于每个整数 A[i]，
 * 我们可以选择 x = -K 或是 x = K，
 * 并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 * <p>
 * 示例 1：
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * <p>
 * 示例 2：
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * <p>
 * 示例 3：
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
public class SmallestRangeII_910 {
    public static int smallestRangeII(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int result = A[n - 1] - A[0];

        for (int i = 0; i < n - 1; i++) {
            int a = A[i];
            int b = A[i + 1];
            int high = Math.max(A[n - 1] - K, a + K);
            int low = Math.min(A[0] + K, b - K);
            result = Math.min(result, high - low);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A_1 = {1};
        int K_1 = 0;
        int i1 = smallestRangeII(A_1, K_1);
        System.out.println(i1);

        int[] A_2 = {0, 10};
        int K_2 = 2;
        int i2 = smallestRangeII(A_2, K_2);
        System.out.println(i2);

        int[] A_3 = {1, 3, 6};
        int K_3 = 3;
        int i3 = smallestRangeII(A_3, K_3);
        System.out.println(i3);
    }
}
