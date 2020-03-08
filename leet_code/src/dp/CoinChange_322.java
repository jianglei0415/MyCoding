package dp;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/3/8 13:26
 * <p>
 * 题号：#322. 零钱兑换
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange_322 {
    private static int coinChange(int[] coins, int amount) {
        //方法一：自下而上
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int i1 = coinChange(coins1, amount1);
        System.out.println(i1);

        int[] coins2 = {2};
        int amount2 = 3;
        int i2 = coinChange(coins2, amount2);
        System.out.println(i2);
    }
}
