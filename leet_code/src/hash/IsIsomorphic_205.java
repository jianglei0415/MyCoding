package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/8/22 21:10
 * <p>
 * 题号：#205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，
 * 同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsIsomorphic_205 {
    public static boolean isIsomorphic(String s, String t) {
        return solve(s, t) && solve(t, s);
    }

    private static boolean solve(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s_1 = "egg", t_1 = "add";
        boolean isomorphic1 = isIsomorphic(s_1, t_1);
        System.out.println(isomorphic1);

        String s_2 = "foo", t_2 = "bar";
        boolean isomorphic2 = isIsomorphic(s_2, t_2);
        System.out.println(isomorphic2);

        String s_3 = "paper", t_3 = "title";
        boolean isomorphic3 = isIsomorphic(s_3, t_3);
        System.out.println(isomorphic3);
    }
}
