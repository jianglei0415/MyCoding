package offer;

/**
 * @author jianglei
 * @date 2020/2/27 22:11
 * <p>
 * 题号：面试题10- II 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级台阶。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），
 * 如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * <p>
 * 提示：
 * 0 <= n <= 100
 * 注意：
 * 本题与主站 509 题相同：
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class NumWays_10_II {
    private static int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int i1 = numWays(n1);
        System.out.println(i1);

        int n2 = 7;
        int i2 = numWays(n2);
        System.out.println(i2);
    }
}
