package string;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/10/14 21:41
 * <p>
 * 题号：#1002. 查找常用字符
 * <p>
 * 给定仅有小写字母组成的字符串数组 A，
 * 返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 *  
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class CommonChars_1002 {
    public static List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String s : A) {
            int[] freq = new int[26];
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                freq[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minfreq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] A_1 = {"bella", "label", "roller"};
        List<String> list1 = commonChars(A_1);
        System.out.println(list1);

        String[] A_2 = {"cool", "lock", "cook"};
        List<String> list2 = commonChars(A_2);
        System.out.println(list2);
    }
}
