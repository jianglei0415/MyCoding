package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/8/10 15:40
 * <p>
 * 题号：#696 计数二进制子串
 * <p>
 * 给定一个字符串 s，
 * 计算具有相同数量0和1的非空(连续)子字符串的数量，
 * 并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，
 * 因为所有的0（和1）没有组合在一起。
 * <p>
 * 示例 2 :
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * <p>
 * 注意：
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 */
public class CountBinarySubstrings_696 {
    public static int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int temp = 0, n = s.length();
        while (temp < n) {
            char a1 = s.charAt(temp);
            int count = 0;
            while (temp < n && s.charAt(temp) == a1) {
                temp++;
                count++;
            }
            counts.add(count);
        }
        int result = 0;
        for (int i = 1; i < counts.size(); i++) {
            result += Math.min(counts.get(i - 1), counts.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "00110011";
        int i1 = countBinarySubstrings(s1);
        System.out.println(i1);

        String s2 = "10101";
        int i2 = countBinarySubstrings(s2);
        System.out.println(i2);
    }
}
