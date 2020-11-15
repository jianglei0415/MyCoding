package offer;

/**
 * @author jianglei
 * @date 2020/11/14 22:16
 * <p>
 * 题号：#剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace_05 {
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println(s1);
    }
}
