package offer;

/**
 * @author: jianglei
 * @date: 2020/2/12 10:49
 * <p>
 * 剑指offer系列
 * <p>
 * 题号：面试题64. 求1+2+…+n
 * <p>
 * 求 1+2+...+n ，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * <p>
 * 限制：
 * 1 <= n <= 10000
 */
public class SumNums_64 {
    private static int sumNums(int n) {
        int result = n;
        boolean flag = (n > 0) && ((result += sumNums(n - 1)) > 0);
        return result;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int i1 = sumNums(n1);
        System.out.println(i1);

        int n2 = 9;
        int i2 = sumNums(n2);
        System.out.println(i2);
    }
}
