package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/11/3 18:43
 * <p>
 * 题号：#1078. Bigram 分词
 * <p>
 * 给出第一个词 first 和第二个词 second，
 * 考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，
 * 其中 second 紧随 first 出现，third 紧随 second 出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 * 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * <p>
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * <p>
 * 提示：
 * 1 <= text.length <= 1000
 * text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 */
public class FindOcurrences_1078 {
    public static String[] findOcurrences(String text, String first, String second) {
        Map<String, String> map = new HashMap<>();
        map.put(first, second);

        String[] s = text.split(" ");
        String[] result = new String[s.length];
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (i < s.length - 2 && map.containsKey(s[i])) {
                if (map.get(s[i]).equals(s[i + 1])) {
                    result[index++] = s[i + 2];
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args) {
        String text_1 = "alice is a good girl she is a good student";
        String first_1 = "a";
        String second_1 = "good";
        String[] ocurrences1 = findOcurrences(text_1, first_1, second_1);
        System.out.println(Arrays.toString(ocurrences1));

        String text_2 = "we will we will rock you";
        String first_2 = "we";
        String second_2 = "will";
        String[] ocurrences2 = findOcurrences(text_2, first_2, second_2);
        System.out.println(Arrays.toString(ocurrences2));
    }
}
