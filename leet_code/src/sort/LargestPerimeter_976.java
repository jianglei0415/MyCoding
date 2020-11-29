package sort;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/11/29 20:17
 * <p>
 * 题号：#976. 三角形的最大周长
 * <p>
 * 给定由一些正数（代表长度）组成的数组 A，
 * 返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 * <p>
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 */
public class LargestPerimeter_976 {
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A_1 = {2, 1, 2};
        int i1 = largestPerimeter(A_1);
        System.out.println(i1);

        int[] A_2 = {1, 2, 1};
        int i2 = largestPerimeter(A_2);
        System.out.println(i2);

        int[] A_3 = {3, 2, 3, 4};
        int i3 = largestPerimeter(A_3);
        System.out.println(i3);

        int[] A_4 = {3, 6, 2, 3};
        int i4 = largestPerimeter(A_4);
        System.out.println(i4);
    }
}
