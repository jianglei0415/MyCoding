package math;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/9/5 20:05
 * <p>
 * 题号：#60. 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * <p>
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * <p>
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class GetPermutation_60 {
    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer result = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    result.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int n_1 = 3, k_1 = 3;
        String permutation1 = getPermutation(n_1, k_1);
        System.out.println(permutation1);

        int n_2 = 4, k_2 = 9;
        String permutation2 = getPermutation(n_2, k_2);
        System.out.println(permutation2);
    }
}
