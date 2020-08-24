package string;

/**
 * @author jianglei
 * @date 2020/8/24 23:12
 * <p>
 * 题号：#28. 实现 strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr_28 {
    public static int strStr(String haystack, String needle) {
        int a = haystack.length();
        int b = needle.length();

        if (b == 0) {
            return 0;
        }

        int move = 0;
        while (move < a - b + 1) {
            while (move < a - b + 1 && haystack.charAt(move) != needle.charAt(0)) {
                move++;
            }

            int currentLength = 0;
            int needleMove = 0;
            while (needleMove < b && move < a && haystack.charAt(move) == needle.charAt(needleMove)) {
                move++;
                needleMove++;
                currentLength++;
            }

            if (currentLength == b) {
                return move - b;
            }

            move = move - currentLength + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack_1 = "hello", needle_1 = "ll";
        int i_1 = strStr(haystack_1, needle_1);
        System.out.println(i_1);

        String haystack_2 = "aaaaa", needle_2 = "bba";
        int i_2 = strStr(haystack_2, needle_2);
        System.out.println(i_2);
    }
}
