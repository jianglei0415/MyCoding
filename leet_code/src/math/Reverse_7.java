package math;

/**
 * @author jianglei
 * @date 2020/9/14 20:24
 * <p>
 * 题号：#7. 整数反转
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse_7 {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int a = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && a > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && a < -8)) {
                return 0;
            }
            result = result * 10 + a;
        }
        return result;
    }

    public static void main(String[] args) {
        int x_1 = 123;
        int reverse1 = reverse(x_1);
        System.out.println(reverse1);

        int x_2 = -123;
        int reverse2 = reverse(x_2);
        System.out.println(reverse2);

        int x_3 = 120;
        int reverse3 = reverse(x_3);
        System.out.println(reverse3);

        int x_4 = 1534236469;
        int reverse4 = reverse(x_4);
        System.out.println(reverse4);
    }
}
