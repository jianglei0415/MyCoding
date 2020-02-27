package array;

/**
 * @author jianglei
 * @date 2020/2/27 22:23
 * <p>
 * 题号：#509 斐波那契数
 * <p>
 * 斐波那契数，通常用 F(n) 表示，
 * 形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，
 * 后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 提示：
 * 0 ≤ N ≤ 30
 */
public class Fib_509 {
    private static int fib(int N) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 0; i < N; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        int N1 = 2;
        int fib1 = fib(N1);
        System.out.println(fib1);

        int N2 = 3;
        int fib2 = fib(N2);
        System.out.println(fib2);

        int N3 = 4;
        int fib3 = fib(N3);
        System.out.println(fib3);
    }
}
