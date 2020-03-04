package offer;

/**
 * @author jianglei
 * @date 2020/2/28 23:16
 * <p>
 * 题号：面试题49. 丑数
 * <p>
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明:  
 * 1 是丑数。
 * n 不超过1690。
 * 注意：
 * 本题与主站 264 题相同：
 * https://leetcode-cn.com/problems/ugly-number-ii/
 */
public class NthUglyNumber_49 {
    private static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) {
                i2++;
            }
            if (min == dp[i3] * 3) {
                i3++;
            }
            if (min == dp[i5] * 5) {
                i5++;
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
