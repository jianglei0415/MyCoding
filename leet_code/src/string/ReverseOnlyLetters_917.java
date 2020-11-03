package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jianglei
 * @date 2020/11/3 18:59
 * <p>
 * 题号：#917. 仅仅反转字母
 * <p>
 * 给定一个字符串 S，返回 “反转后的” 字符串，
 * 其中不是字母的字符都保留在原地，
 * 而所有字母的位置发生反转。
 * <p>
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 * <p>
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * 提示：
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 */
public class ReverseOnlyLetters_917 {
    public static String reverseOnlyLetters(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(stack.pop());
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String S_1 = "ab-cd";
        String s1 = reverseOnlyLetters(S_1);
        System.out.println(s1);

        String S_2 = "a-bC-dEf-ghIj";
        String s2 = reverseOnlyLetters(S_2);
        System.out.println(s2);

        String S_3 = "Test1ng-Leet=code-Q!";
        String s3 = reverseOnlyLetters(S_3);
        System.out.println(s3);
    }
}
