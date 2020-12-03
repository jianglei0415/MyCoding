package math;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/12/3 21:33
 * <p>
 * 题号：#204. 计数质数
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * <p>
 * 提示：
 * 0 <= n <= 5 * 106
 */
public class CountPrimes_204 {
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n_1 = 10;
        int i1 = countPrimes(n_1);
        System.out.println(i1);

        int n_2 = 0;
        int i2 = countPrimes(n_2);
        System.out.println(i2);

        int n_3 = 1;
        int i3 = countPrimes(n_3);
        System.out.println(i3);
    }
}
