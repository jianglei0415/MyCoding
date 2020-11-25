package string;

/**
 * @author jianglei
 * @date 2020/11/25 21:41
 * <p>
 * 题号：#1556. 千位分隔数
 * <p>
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，
 * 并将结果以字符串格式返回。
 * <p>
 * 示例 1：
 * 输入：n = 987
 * 输出："987"
 * <p>
 * 示例 2：
 * 输入：n = 1234
 * 输出："1.234"
 * <p>
 * 示例 3：
 * 输入：n = 123456789
 * 输出："123.456.789"
 * <p>
 * 示例 4：
 * 输入：n = 0
 * 输出："0"
 * <p>
 * 提示：
 * 0 <= n < 2^31
 */
public class ThousandSeparator_1556 {
    public static String thousandSeparator(int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        do {
            int cur = n % 10;
            n /= 10;
            sb.append(cur);
            count++;
            if (count % 3 == 0 && n != 0) {
                sb.append('.');
            }
        } while (n != 0);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int n_1 = 987;
        String s1 = thousandSeparator(n_1);
        System.out.println(s1);

        int n_2 = 1234;
        String s2 = thousandSeparator(n_2);
        System.out.println(s2);

        int n_3 = 123456789;
        String s3 = thousandSeparator(n_3);
        System.out.println(s3);

        int n_4 = 0;
        String s4 = thousandSeparator(n_4);
        System.out.println(s4);
    }
}
