package offer;

/**
 * @author jianglei
 * @date 2021/6/15 22:17
 * <p>
 * 题号：#剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制：
 * 1 <= k < s.length <= 10000
 */
public class ReverseLeftWords_58_II {
    public static String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        StringBuilder builder = new StringBuilder(s2);
        builder.append(s1);
        return builder.toString();
    }

    public static void main(String[] args) {
        String words1 = reverseLeftWords("abcdefg", 2);
        System.out.println(words1);

        String words2 = reverseLeftWords("lrloseumgh", 6);
        System.out.println(words2);
    }
}
