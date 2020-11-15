package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianglei
 * @date 2020/11/15 16:56
 * <p>
 * 题号：#402. 移掉K位数字
 * <p>
 * 给定一个以字符串表示的非负整数 num，
 * 移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class RemoveKdigits_402 {
    /**
     * 与方法二基本类似  无栈做法
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < num.length() && k > 0) {
            char curr = num.charAt(i);
            if (sb.length() == 0) {
                sb.append(curr);
            } else {
                while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > curr) {
                    sb.deleteCharAt(sb.length() - 1);
                    k--;
                }
                sb.append(curr);
            }
            i++;
        }

        //防止k或者i没有用完
        for (int j = 0; j < k; j++) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(num.substring(i));

        i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        return i == sb.length() ? "0" : sb.substring(i);
    }

    /**
     * 方法二：基于栈
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits_2(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char curr = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > curr) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(curr);
        }

        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (!stack.isEmpty()) {
            char curr = stack.pollFirst();
            if (flag && curr == '0') {
                continue;
            }

            flag = false;
            sb.append(curr);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num_1 = "1432219";
        int k_1 = 3;
        String s1 = removeKdigits(num_1, k_1);
        System.out.println(s1);

        String num_2 = "10200";
        int k_2 = 1;
        String s2 = removeKdigits(num_2, k_2);
        System.out.println(s2);

        String num_3 = "10";
        int k_3 = 2;
        String s3 = removeKdigits(num_3, k_3);
        System.out.println(s3);
    }
}
