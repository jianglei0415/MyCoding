package dp;

/**
 * @author jianglei
 * @date 2020/9/29 19:59
 * <p>
 * 题号：#312. 戳气球
 * <p>
 * 有 n 个气球，编号为0 到 n-1，
 * 每个气球上都标有一个数字，
 * 这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。
 * 如果你戳破气球 i ，
 * 就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
 * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * 你可以假设 nums[-1] = nums[n] = 1，
 * 但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * 示例:
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class MaxCoins_312 {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];

        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }

        return dp[0][n + 1];
    }

    public static int maxCoins2(int[] nums) {
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) {
                num[n++] = x;
            }
        }
        num[0] = num[n++] = 1;

        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            for (int left = 0; left < n - i; left++) {
                int right = left + i;
                for (int j = left + 1; j < right; j++) {
                    dp[left][right] = Math.max(dp[left][right], num[left] * num[j] * num[right] + dp[left][j] + dp[j][right]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int i = maxCoins(nums);
        System.out.println(i);

        int i2 = maxCoins2(nums);
        System.out.println(i2);
    }
}
