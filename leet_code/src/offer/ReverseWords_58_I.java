package offer;

/**
 * @author jianglei
 * @date 2020/2/28 22:34
 * <p>
 * 题号：面试题58 - I. 翻转单词顺序
 * <p>
 * 输入一个英文句子，
 * 翻转句子中单词的顺序，
 * 但单词内字符的顺序不变。
 * 为简单起见，
 * 标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，
 * 但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，
 * 将反转后单词间的空格减少到只含一个。
 * 注意：
 * 本题与主站 151 题相同：
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * <p>
 * 注意：此题对比原题有改动
 */
public class ReverseWords_58_I {
    private static String reverseWords(String s) {
        s = s.trim();
        if (s.equals("")) {
            return "";
        }
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")) {
                continue;
            }
            sb.append(s1[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s_1 = reverseWords(s1);
        System.out.println(s_1);

        String s2 = "  hello world!  ";
        String s_2 = reverseWords(s2);
        System.out.println(s_2);

        String s3 = "a good   example";
        String s_3 = reverseWords(s3);
        System.out.println(s_3);
    }
}
