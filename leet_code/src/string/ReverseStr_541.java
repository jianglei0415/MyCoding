package string;

/**
 * @author jianglei
 * @date 2020/8/30 16:26
 * <p>
 * 题号：#541. 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k，
 * 你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * <p>
 * 提示：
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 */
public class ReverseStr_541 {
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += k * 2) {
            int x = i, y = Math.min(i + k - 1, chars.length - 1);
            while (x < y) {
                char temp = chars[x];
                chars[x++] = chars[y];
                chars[y--] = temp;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s_1 = "abcdefg";
        int k_1 = 2;
        String s1 = reverseStr(s_1, k_1);
        System.out.println(s1);
    }
}
