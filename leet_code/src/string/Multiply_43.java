package string;

/**
 * @author jianglei
 * @date 2020/8/13 21:33
 * <p>
 * 题号：#43 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply_43 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num1.equals("1")) {
            return num2;
        }

        if (num2.equals("1")) {
            return num1;
        }

        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            //进位
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }

            int n2 = num2.charAt(i) - '0';

            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            result = addStrings(result, temp.reverse().toString());
        }
        return result;
    }

    private static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    public static String multiply2(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "";
        } else if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if (num1.equals("1")) {
            return num2;
        }

        if (num2.equals("1")) {
            return num1;
        }

        char[] number1 = num1.toCharArray();
        char[] number2 = num2.toCharArray();
        int[] result = new int[number1.length + number2.length];
        int start = 0;

        for (int i = number1.length - 1; i >= 0; i--) {
            int d = number1[i] - '0';
            int k = start;

            for (int j = number2.length - 1; j >= 0; j--) {
                result[k++] += (number2[j] - '0') * d;
            }

            start++;
        }

        int rem = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] += rem;
            rem = result[i] / 10;
            result[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int i = number1.length + number2.length - 1;

        while (result[i] == 0) {
            i--;
        }

        while (i >= 0) {
            sb.append(result[i]);
            i--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String nums11 = "2";
        String nums21 = "3";
        String multiply1 = multiply(nums11, nums21);
        System.out.println(multiply1);

        String nums12 = "123";
        String nums22 = "456";
        String multiply2 = multiply2(nums12, nums22);
        System.out.println(multiply2);
    }
}
