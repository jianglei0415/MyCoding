package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author jianglei
 * @date 2021/6/22 23:00
 * <p>
 * 题号：#剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 */
public class Permutation_38 {
    private static Set<String> result = new LinkedHashSet<>();

    public static String[] permutation(String s) {
        boolean[] used = new boolean[s.length()];
        dfs(used, s, 0, new StringBuilder());
        return result.toArray(new String[]{});
    }

    private static void dfs(boolean[] used, String s, int start, StringBuilder sb) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) {
                continue;
            } else {
                used[i] = true;
                sb.append(s.charAt(i));
                dfs(used, s, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = permutation("abc");
        System.out.println(Arrays.toString(strings));
    }
}
