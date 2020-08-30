package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/8/30 17:28
 * <p>
 * 题号：#345. 反转字符串中的元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 * <p>
 * 提示：
 * 元音字母不包含字母 "y" 。
 */
public class ReverseVowels_345 {
    private static Set<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (left < s.length() && !set.contains(chars[left])) {
                left++;
            }
            while (right >= 0 && !set.contains(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s_1 = "hello";
        String s1 = reverseVowels(s_1);
        System.out.println(s1);

        String s_2 = "leetcode";
        String s2 = reverseVowels(s_2);
        System.out.println(s2);
    }
}
