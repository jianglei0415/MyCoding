package math;

/**
 * @author jianglei
 * @date 2020/8/23 16:40
 * <p>
 * 题号：#908. 最小差值 I
 * <p>
 * 给你一个整数数组 A，
 * 请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），
 * 从而得到一个新数组 B 。
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 * <p>
 * 示例 1：
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * <p>
 * 示例 2：
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * <p>
 * 示例 3：
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
public class SmallestRangeI_908 {
    public static int smallestRangeI(int[] A, int K) {
        int max = A[0], min = A[0];
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return Math.max(0, max - min - 2 * K);
    }

    public static void main(String[] args) {
        int[] A_1 = {1};
        int K_1 = 0;
        int i1 = smallestRangeI(A_1, K_1);
        System.out.println(i1);

        int[] A_2 = {0, 10};
        int K_2 = 2;
        int i2 = smallestRangeI(A_2, K_2);
        System.out.println(i2);

        int[] A_3 = {1, 3, 6};
        int K_3 = 3;
        int i3 = smallestRangeI(A_3, K_3);
        System.out.println(i3);
    }
}
