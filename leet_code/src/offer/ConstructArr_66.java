package offer;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/11/23 21:05
 * <p>
 * 题号：#剑指 Offer 66. 构建乘积数组
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 * <p>
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class ConstructArr_66 {
    public static int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }

        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a_1 = {1, 2, 3, 4, 5};
        int[] ints = constructArr(a_1);
        System.out.println(Arrays.toString(ints));
    }
}
