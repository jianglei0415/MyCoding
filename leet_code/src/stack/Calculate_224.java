package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianglei
 * @date 2021/3/10 20:33
 * <p>
 * 题号：#224. 基本计算器
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class Calculate_224 {
    /**
     * 思路：
     * 首先用一个栈存当前值的正负值（默认先为正，也就是1，负的话就是相反数，-1）。
     * 依次遍历字符串。
     * 如果碰到的字符串为+，则将当前栈顶的正负值赋给当前正负值；
     * 如果碰到的字符串为-，则将当前栈顶的正负值的相反数赋给当前正负值;
     * 如果碰到的字符串为（，则将当前正负值压入栈顶;
     * 如果碰到字符串为），则将当前栈顶弹出；
     * 如果碰到的字符串为数字，则还得根据遍历得到的字符串组成数字，并且当碰到的不是数字时将当前结果与当前正负值相乘得出当前的结果。
     * 如果最后遍历完毕之后，得到的结果就是该表达式的结果。
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int sign = 1, result = 0, n = s.length(), i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                result += sign * num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i1 = calculate("1 + 1");
        System.out.println(i1);

        int i2 = calculate(" 2-1 + 2 ");
        System.out.println(i2);

        int i3 = calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(i3);
    }
}
