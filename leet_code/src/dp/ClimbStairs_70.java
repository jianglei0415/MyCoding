package dp;

/**
 * @author jianglei
 * @date 2020/9/10 8:59
 * <p>
 * 题号：#70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。
 * 需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。
 * 你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs_70 {
    public static int climbStairs(int n) {
        int first = 1, secod = 2, result = 0;
        if (n < 2) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        for (int i = 3; i <= n; i++) {
            result = first + secod;
            first = secod;
            secod = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n_1 = 2;
        int i1 = climbStairs(n_1);
        System.out.println(i1);

        int n_2 = 3;
        int i2 = climbStairs(n_2);
        System.out.println(i2);
    }
}
