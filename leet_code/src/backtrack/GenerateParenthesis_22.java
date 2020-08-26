package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/8/26 22:46
 * <p>
 * 题号：#22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，
 * 请你设计一个函数，
 * 用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }
}
