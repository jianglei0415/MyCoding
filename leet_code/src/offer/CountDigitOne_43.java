package offer;

/**
 * @author jianglei
 * @date 2020/2/28 23:02
 * <p>
 * 题号：面试题43. 1～n整数中1出现的次数
 * <p>
 * 输入一个整数 n ，
 * 求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，
 * 输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：6
 * <p>
 * 限制：
 * 1 <= n < 2^31
 * 注意：
 * 本题与主站 233 题相同：
 * https://leetcode-cn.com/problems/number-of-digit-one/
 */
public class CountDigitOne_43 {
    private static int countDigitOne(int n) {
        return dfs(n);
    }

    private static int dfs(int n) {
        if (n <= 0) {
            return 0;
        }
        String num = String.valueOf(n);
        int high = num.charAt(0) - '0';
        int pow = (int) Math.pow(10, num.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return dfs(pow - 1) + dfs(last) + last + 1;
        } else {
            return pow + high * dfs(pow - 1) + dfs(last);
        }
    }

    public static void main(String[] args) {
        int n1 = 12;
        int i1 = countDigitOne(n1);
        System.out.println(i1);

        int n2 = 13;
        int i2 = countDigitOne(n2);
        System.out.println(i2);
    }
}
