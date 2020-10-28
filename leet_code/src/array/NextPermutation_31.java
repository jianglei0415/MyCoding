package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/5 11:26
 * <p>
 * 题号：#31 下一个排列
 * <p>
 * 实现获取下一个排列的函数，
 * 算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，
 * 则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，
 * 输入位于左侧列，
 * 其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation_31 {
    private static int[] nextPermutation(int[] nums) {
        if (nums == null) {
            return nums;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
                return nums;
            } else {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, nums.length);
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            return nums;
                        }
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] i1 = nextPermutation(nums1);
        System.out.println(Arrays.toString(i1));

        int[] nums2 = {3, 2, 1};
        int[] i2 = nextPermutation(nums2);
        System.out.println(Arrays.toString(i2));

        int[] nums3 = {1, 1, 5};
        int[] i3 = nextPermutation(nums3);
        System.out.println(Arrays.toString(i3));
    }
}
