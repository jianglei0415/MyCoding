package math;

/**
 * @author jianglei
 * @date 2020/3/4 16:59
 * <p>
 * 题号：#263.丑数
 * <p>
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * <p>
 * 示例 3:
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * <p>
 * 说明：
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 */         
public class IsUgly_263 {
    private static boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num1 = 6;
        boolean ugly1 = isUgly(num1);
        System.out.println(ugly1);

        int num2 = 8;
        boolean ugly2 = isUgly(num2);
        System.out.println(ugly2);

        int num3 = 14;
        boolean ugly3 = isUgly(num3);
        System.out.println(ugly3);
    }
}
