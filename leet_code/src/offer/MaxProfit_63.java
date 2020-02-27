package offer;

/**
 * @author jianglei
 * @date 2020/2/28 0:39
 * <p>
 * 题号：面试题63. 股票的最大利润
 * <p>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，
 * 在第 5 天（股票价格 = 6）的时候卖出，
 * 最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6,
 * 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下,
 * 没有交易完成,
 * 所以最大利润为 0。、
 * <p>
 * 限制：、
 * 0 <= 数组长度 <= 10^5、
 * <p>
 * 注意：本题与主站 121 题相同：
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit_63 {
    private static int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int i1 = maxProfit(prices1);
        System.out.println(i1);

        int[] prices2 = {7, 6, 4, 3, 1, 1};
        int i2 = maxProfit(prices2);
        System.out.println(i2);
    }
}
