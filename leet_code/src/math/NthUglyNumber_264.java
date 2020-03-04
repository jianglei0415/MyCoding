package math;

/**
 * @author jianglei
 * @date 2020/3/4 16:52
 * <p>
 * 题号：#264丑数 II
 * <p>
 * 编写一个程序，
 * 找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数
 * <p>
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 */
public class NthUglyNumber_264 {
    private static int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int n2 = 0, n3 = 0, n5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[n2] * 2, Math.min(dp[n3] * 3, dp[n5] * 5));
            if (min == dp[n2] * 2) {
                n2++;
            }
            if (min == dp[n3] * 3) {
                n3++;
            }
            if (min == dp[n5] * 5) {
                n5++;
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        int i = nthUglyNumber(n);
        System.out.println(i);
    }
}
