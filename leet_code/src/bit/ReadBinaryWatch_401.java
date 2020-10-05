package bit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/10/5 15:09
 * <p>
 * 题号：#401. 二进制手表
 * <p>
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * 示例：
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * 提示：
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 */
public class ReadBinaryWatch_401 {
    public static List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    result.add(pack(i, j));
                }
            }
        }
        return result;
    }

    private static String pack(int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i).append(":");
        if (j < 10) {
            sb.append(0);
        }
        sb.append(j);
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 1;
        List<String> list = readBinaryWatch(num);
        System.out.println(list);
    }
}
