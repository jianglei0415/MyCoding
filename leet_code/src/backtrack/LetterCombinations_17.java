package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/8/26 22:09
 * <p>
 * 题号：#17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，
 * 返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。
 * 注意 1 不对应任何字母。
 * <p>
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations_17 {
    private static List<String> result = new ArrayList<>();
    private static Map<Character, String> phoneMap = new HashMap<>();

    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pgrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String s = phoneMap.get(digit);
            int length = s.length();
            for (int i = 0; i < length; i++) {
                sb.append(s.charAt(i));
                backtrack(digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println(list);
    }
}
