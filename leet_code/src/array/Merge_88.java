package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/8 23:34
 * <p>
 * 题号：#88 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，
 * 将 nums2 合并到 nums1 中，
 * 使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class Merge_88 {
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        int c = m + b - 1;
        while ((a >= 0) && (b >= 0)) {
            nums1[c--] = (nums1[a] < nums2[b]) ? nums2[b--] : nums1[a--];
        }
        System.arraycopy(nums2, 0, nums1, 0, b + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
