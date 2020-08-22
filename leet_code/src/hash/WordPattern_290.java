package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/8/22 21:41
 * <p>
 * 题号：#290. 单词规律
 * <p>
 * 给定一种规律 pattern 和一个字符串 str ，
 * 判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，
 * 例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class WordPattern_290 {
    public static boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        if (pattern.length() != s.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            String s1 = s[i];
            if (map.containsKey(c1)) {
                if (!map.get(c1).equals(s1)) {
                    return false;
                }
            } else {
                if (set.contains(s1)) {
                    return false;
                }
                map.put(c1, s1);
                set.add(s1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern_1 = "abba", str_1 = "dog cat cat dog";
        boolean b1 = wordPattern(pattern_1, str_1);
        System.out.println(b1);

        String pattern_2 = "abba", str_2 = "dog cat cat fish";
        boolean b2 = wordPattern(pattern_2, str_2);
        System.out.println(b2);

        String pattern_3 = "aaaa", str_3 = "dog cat cat dog";
        boolean b3 = wordPattern(pattern_3, str_3);
        System.out.println(b3);

        String pattern_4 = "abba", str_4 = "dog dog dog dog";
        boolean b4 = wordPattern(pattern_4, str_4);
        System.out.println(b4);
    }
}
