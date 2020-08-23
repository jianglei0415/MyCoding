package bit;

/**
 * @author jianglei
 * @date 2020/8/23 11:42
 * <p>
 * 题号：#201. 数字范围按位与
 * <p>
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
 * 返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1: 
 * 输入: [5,7]
 * 输出: 4
 * <p>
 * 示例 2:
 * 输入: [0,1]
 * 输出: 0
 */
public class RangeBitwiseAnd_201 {
    public static int rangeBitwiseAnd(int m, int n) {
//        int result = m;
//        for (int i = m + 1; i <= n; i++) {
//            result &= i;
//        }
//        return result;

        int count=0;
        while (n>m){
            m>>=1;
            n>>=1;
            count++;
        }
        return m<<count;
    }

    public static void main(String[] args) {
        int m_1 = 5, n_1 = 7;
        int i1 = rangeBitwiseAnd(m_1, n_1);
        System.out.println(i1);

        int m_2 = 0, n_2 = 1;
        int i2 = rangeBitwiseAnd(m_2, n_2);
        System.out.println(i2);
    }
}
