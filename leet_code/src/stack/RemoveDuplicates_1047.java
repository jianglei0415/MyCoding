package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author jianglei
 * @date 2021/3/9 21:57
 * <p>
 * 题号：#1047. 删除字符串中的所有相邻重复项
 * <p>
 * 给出由小写字母组成的字符串 S，
 * 重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class RemoveDuplicates_1047 {
    /**
     * 输入一个字符串，并判断相邻两个字符是否相同，如果相同则删除，否则继续；
     * 可以用一个栈的进栈出栈来进行判断字符是否相同：
     * 如果相同则pop，否则offer，
     * 最后将栈中的元素按顺序输出。
     *
     * @param S 输入字符串
     * @return result
     */
    public static String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        int n = S.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.offer(S.charAt(i));
                continue;
            }

            if (!stack.isEmpty() && stack.peekLast() == S.charAt(i)) {
                stack.pollLast();
            } else {
                stack.offerLast(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String duplicates = removeDuplicates("abbaca");
        System.out.println(duplicates);
    }
}
