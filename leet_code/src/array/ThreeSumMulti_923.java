package array;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/3/7 13:59
 * <p>
 * 题号：#923. 三数之和的多种可能
 * <p>
 * 给定一个整数数组 A，
 * 以及一个整数 target 作为目标值，
 * 返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 * <p>
 * 示例 1：
 * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举（A[i]，A[j]，A[k]）：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * <p>
 * 示例 2：
 * 输入：A = [1,1,2,2,2,2], target = 5
 * 输出：12
 * 解释：
 * A[i] = 1，A[j] = A[k] = 2 出现 12 次：
 * 我们从 [1,1] 中选择一个 1，有 2 种情况，
 * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 * <p>
 * 提示：
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 */
public class ThreeSumMulti_923 {
    private static int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length; ++i) {
            int T = target - A[i];
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                if (A[j] + A[k] < T) {
                    j++;
                } else if (A[j] + A[k] > T) {
                    k--;
                } else if (A[j] != A[k]) {
                    int left = 1, right = 1;
                    while (j + 1 < k && A[j] == A[j + 1]) {
                        left++;
                        j++;
                    }
                    while (k - 1 > j && A[k] == A[k - 1]) {
                        right++;
                        k--;
                    }
                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    ans += (k - j + 1) * (k - j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target1 = 8;
        int i1 = threeSumMulti(A1, target1);
        System.out.println(i1);

        int[] A2 = {1, 1, 2, 2, 2, 2};
        int target2 = 5;
        int i2 = threeSumMulti(A2, target2);
        System.out.println(i2);
    }
}
