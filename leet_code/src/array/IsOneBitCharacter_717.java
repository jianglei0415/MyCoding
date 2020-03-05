package array;

/**
 * @author jianglei
 * @date 2020/3/5 16:17
 * <p>
 * 题号：#717. 1比特与2比特字符
 * <p>
 * 有两种特殊字符。
 * 第一种字符可以用一比特0来表示。
 * 第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。
 * 问最后一个字符是否必定为一个一比特字符。
 * 给定的字符串总是由0结束。
 * <p>
 * 示例 1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * <p>
 * 示例 2:
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * <p>
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * <p>
 * 注意:
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 */
public class IsOneBitCharacter_717 {
    private static boolean isOneBitCharacter(int[] bits) {
        if (bits == null) {
            return false;
        }
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        int[] bits1 = {1, 0, 0};
        boolean character1 = isOneBitCharacter(bits1);
        System.out.println(character1);

        int[] bits2 = {1, 1, 1, 0};
        boolean character2 = isOneBitCharacter(bits2);
        System.out.println(character2);
    }
}
