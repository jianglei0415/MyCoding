package math;

/**
 * @author jianglei
 * @date 2020/2/28 23:06
 * <p>
 * 题号：#233 数字 1 的个数
 * <p>
 * 给定一个整数 n，
 * 计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 示例:
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13
 */
public class CountDigitOne_233 {
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
        int n = 13;
        int i = countDigitOne(n);
        System.out.println(i);
    }
}
