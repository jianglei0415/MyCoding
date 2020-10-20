package list;

/**
 * @author jianglei
 * @date 2020/10/19 11:22
 * <p>
 * 题号：#844. 比较含退格的字符串
 * <p>
 * 给定 S 和 T 两个字符串，
 * 当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。
 * # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * 进阶：
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class BackspaceCompare_844 {
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder s_temp = new StringBuilder();
        StringBuilder t_temp = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (i == 0 && S.charAt(i) == '#') {
                continue;
            } else if (i != 0 && S.charAt(i) == '#' && s_temp.length() == 0) {
                continue;
            } else if (i != 0 && S.charAt(i) == '#') {
                s_temp.deleteCharAt(s_temp.length() - 1);
            } else {
                s_temp.append(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (i == 0 && T.charAt(i) == '#') {
                continue;
            } else if (i != 0 && T.charAt(i) == '#' && t_temp.length() == 0) {
                continue;
            } else if (i != 0 && T.charAt(i) == '#') {
                t_temp.deleteCharAt(t_temp.length() - 1);
            } else {
                t_temp.append(T.charAt(i));
            }
        }

        if (s_temp.toString().equals(t_temp.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String S_1 = "ab#c", T_1 = "ad#c";
        boolean b1 = backspaceCompare(S_1, T_1);
        System.out.println(b1);

        String S_2 = "ab##", T_2 = "c#d#";
        boolean b2 = backspaceCompare(S_2, T_2);
        System.out.println(b2);

        String S_3 = "a##c", T_3 = "#a#c";
        boolean b3 = backspaceCompare(S_3, T_3);
        System.out.println(b3);

        String S_4 = "a#c", T_4 = "b";
        boolean b4 = backspaceCompare(S_4, T_4);
        System.out.println(b4);
    }
}
