package string;

/**
 * @author jianglei
 * @date 2021/6/29 20:53
 * <p>
 * 题号：#168. Excel表列名称
 * <p>
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1：
 * 输入：columnNumber = 1
 * 输出："A"
 * <p>
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * <p>
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * <p>
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * <p>
 * 提示：
 * 1 <= columnNumber <= 231 - 1
 */
public class ConvertToTitle_168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int i = (columnNumber - 1) % 26 + 1;
            sb.append((char) (i - 1 + 'A'));
            columnNumber = (columnNumber - i) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = convertToTitle(1);
        System.out.println(s1);

        String s2 = convertToTitle(28);
        System.out.println(s2);

        String s3 = convertToTitle(701);
        System.out.println(s3);

        String s4 = convertToTitle(2147483647);
        System.out.println(s4);
    }
}
