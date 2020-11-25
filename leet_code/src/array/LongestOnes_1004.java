package array;

/**
 * @author jianglei
 * @date 2020/11/25 21:21
 * <p>
 * 题号：#1004. 最大连续1的个数 III
 * <p>
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 提示：
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 */
public class LongestOnes_1004 {
    public static int longestOnes(int[] A, int K) {
        int result = Integer.MIN_VALUE;
        int left = 0, right = 0;

        for (; right < A.length; right++) {
            if (A[right] == 0) {
                if (K > 0) {
                    K--;
                } else {
                    result = Math.max(result, right - left);
                    while (A[left++] == 1){}
                }
            }
        }
        return Math.max(result, right - left);
    }

    public static void main(String[] args) {
        int[] A_1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K_1 = 2;
        int i1 = longestOnes(A_1, K_1);
        System.out.println(i1);

        int[] A_2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K_2 = 3;
        int i2 = longestOnes(A_2, K_2);
        System.out.println(i2);
    }
}
