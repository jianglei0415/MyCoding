package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianglei
 * @date 2021/3/10 21:37
 * <p>
 * 题号：#150. 逆波兰表达式求值
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。
 * 每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。
 * 换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 */
public class EvalRPN_150 {
    /**
     * 思路：
     * 通过使用栈来存放数字。
     * 通过遍历数组根据得到的字符串进行相应的加、减、乘、除操作，
     * 并依次将得到的结果数加入栈顶。
     * 最后栈中剩余的数字即为该逆波兰式的结果。
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Integer var1, var2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    var2 = stack.pop();
                    var1 = stack.pop();
                    stack.push(var1 + var2);
                    break;
                case "-":
                    var2 = stack.pop();
                    var1 = stack.pop();
                    stack.push(var1 - var2);
                    break;
                case "*":
                    var2 = stack.pop();
                    var1 = stack.pop();
                    stack.push(var1 * var2);
                    break;
                case "/":
                    var2 = stack.pop();
                    var1 = stack.pop();
                    stack.push(var1 / var2);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens_1 = {"2", "1", "+", "3", "*"};
        int i1 = evalRPN(tokens_1);
        System.out.println(i1);

        String[] tokens_2 = {"4", "13", "5", "/", "+"};
        int i2 = evalRPN(tokens_2);
        System.out.println(i2);

        String[] tokens_3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i3 = evalRPN(tokens_3);
        System.out.println(i3);
    }
}
