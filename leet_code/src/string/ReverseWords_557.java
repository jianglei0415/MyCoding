package string;

/**
 * @author jianglei
 * @date 2020/8/30 15:34
 * <p>
 * 题号：#557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWords_557 {
    public static String reverseWords1(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            StringBuilder temp = new StringBuilder(s1[i]);
            sb.append(temp.reverse());
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[s.length()];
        int left = 0;
        int right = 0;
        int curr = 0;
        while (left < s.length() && right < s.length()) {
            while (right < s.length() && chars[right] != ' ') {
                right++;
            }

            for (int i = right - 1; i >= left; i--) {
                result[curr++] = chars[i];
            }

            if (curr < s.length() - 1) {
                result[curr++] = ' ';
            }

            left = ++right;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String s_1 = "Let's take LeetCode contest";
        String s1 = reverseWords1(s_1);
        System.out.println(s1);

        String s_2 = "Let's take LeetCode contest";
        String s2 = reverseWords2(s_2);
        System.out.println(s2);
    }
}
