package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/8/9 22:17
 * <p>
 * 题号：#93 复原IP地址
 * <p>
 * 给定一个只包含数字的字符串，
 * 复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），
 * 整数之间用 '.' 分隔。
 * <p>
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIpAddresses_93 {
    private static List<String> result = new ArrayList<>();

    public static List<String> restoreIpAddresses(String s) {
        int[] temp = new int[4];
        backtrack(s, 0, 0, temp);
        return result;
    }

    /**
     * @param s       字符串序列
     * @param start   可选择字符串的其实索引
     * @param tempNum 已得到的整数个数
     * @param temp    存储当前路径
     */
    private static void backtrack(String s, int start, int tempNum, int[] temp) {
        //到达结束时间
        if (tempNum == 4) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(temp[i]).append(".");
                }
                sb.append(temp[3]);
                result.add(sb.toString());
            }
            return;
        }

        //提前回溯
        if (start == s.length()) {
            return;
        }

        //约束条件，0开头，特别处理
        if (s.charAt(start) == '0') {
            temp[tempNum] = 0;
            backtrack(s, start + 1, tempNum + 1, temp);
        }

        int temp1 = 0;
        for (int end = start; end < s.length(); end++) {
            //做选择
            temp1 = temp1 * 10 + (s.charAt(end) - '0');
            if (temp1 > 0 && temp1 <= 255) {
                temp[tempNum] = temp1;
                backtrack(s, end + 1, tempNum + 1, temp);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = restoreIpAddresses(s);
        System.out.println(list);
    }
}
