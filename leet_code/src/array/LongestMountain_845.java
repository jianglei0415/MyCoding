package array;

/**
 * @author jianglei
 * @date 2020/10/25 15:39
 * <p>
 * 题号：#845. 数组中的最长山脉
 * <p>
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * <p>
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * <p>
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class LongestMountain_845 {
    public static int longestMountain(int[] A) {
        int result = 0;

        int n = A.length;
        if (n == 0) {
            return result;
        }

        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }

        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            if (left[i] > 0 && right[i] > 0) {
                result = Math.max(result, left[i] + right[i] + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A_1 = {2, 1, 4, 7, 3, 2, 5};
        int i1 = longestMountain(A_1);
        System.out.println(i1);

        int[] A_2 = {2, 2, 2};
        int i2 = longestMountain(A_2);
        System.out.println(i2);
    }
}
