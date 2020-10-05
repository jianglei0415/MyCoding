package bit;

/**
 * @author jianglei
 * @date 2020/10/5 13:40
 * <p>
 * 题号：#231. 2的幂
 * <p>
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * <p>
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * <p>
 * 示例 3:
 * 输入: 218
 * 输出: false
 */
public class IsPowerOfTwo_231 {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long temp = (long) n;
        return (temp & (temp - 1)) == 0;
    }

    public static void main(String[] args) {
        int n_1 = 1;
        boolean powerOfTwo1 = isPowerOfTwo(n_1);
        System.out.println(powerOfTwo1);

        int n_2 = 16;
        boolean powerOfTwo2 = isPowerOfTwo(n_2);
        System.out.println(powerOfTwo2);

        int n_3 = 218;
        boolean powerOfTwo3 = isPowerOfTwo(n_3);
        System.out.println(powerOfTwo3);

        int n_4 = Integer.MIN_VALUE;
        boolean powerOfTwo4 = isPowerOfTwo(n_4);
        System.out.println(powerOfTwo4);
    }
}
