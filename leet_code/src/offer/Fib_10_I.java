package offer;

/**
 * @author jianglei
 * @date 2020/2/27 22:35
 * <p>
 * 题号：面试题10-I 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，
 * 求斐波那契（Fibonacci）数列的第 n 项。
 * 斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，
 * 之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），
 * 如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * <p>
 * 提示：
 * 0 <= n <= 100
 * 注意：本题与主站 509 题相同：
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Fib_10_I {
    private static int fib(int n) {
        int a = 0;
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
        int fib1 = fib(n1);
        System.out.println(fib1);

        int n2 = 5;
        int fib2 = fib(n2);
        System.out.println(fib2);
    }
}
