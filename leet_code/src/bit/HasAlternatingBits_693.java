package bit;

/**
 * @author jianglei
 * @date 2020/10/5 16:06
 * <p>
 * 题号：#693. 交替位二进制数
 * <p>
 * 给定一个正整数，
 * 检查他是否为交替位二进制数：
 * 换句话说，就是他的二进制数相邻的两个位数永不相等。
 * <p>
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * <p>
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * <p>
 * 示例 3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * <p>
 * 示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 */
public class HasAlternatingBits_693 {
    public static boolean hasAlternatingBits(int n) {
        int i = n ^ (n >> 1);
        if ((i & ((long) i + 1)) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n_1 = 5;
        boolean b1 = hasAlternatingBits(n_1);
        System.out.println(b1);

        int n_2 = 7;
        boolean b2 = hasAlternatingBits(n_2);
        System.out.println(b2);

        int n_3 = 11;
        boolean b3 = hasAlternatingBits(n_3);
        System.out.println(b3);

        int n_4 = 10;
        boolean b4 = hasAlternatingBits(n_4);
        System.out.println(b4);
    }
}
