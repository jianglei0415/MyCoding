package string;

/**
 * @author jianglei
 * @date 2020/2/28 22:38
 * <p>
 * 题号：#151. 翻转字符串里的单词
 * <p>
 * 给定一个字符串，
 * 逐个翻转字符串中的每个单词。
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
 */
public class ReverseWords_151 {
    private static String reverseWords(String s) {
        s = s.trim();
        if (s.equals("")) {
            return "";
        }
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            s1[i].trim();
            if (s1[i].equals("")) {
                continue;
            }
            stringBuilder.append(s1[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
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
