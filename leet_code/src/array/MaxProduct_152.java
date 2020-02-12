package array;

/**
 * @author: jianglei
 * @date: 2020/2/12 14:15
 * <p>
 * 题号：#152 乘积最大子序列
 * <p>
 * 给定一个整数数组 nums ，
 * 找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct_152 {
    private static int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        if (nums == null) {
            return result;
        }
        int max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int i1 = maxProduct(nums1);
        System.out.println(i1);

        int[] nums2 = {-2, 0, -1};
        int i2 = maxProduct(nums2);
        System.out.println(i2);

        int[] nums3 = {-1, -2, -9, -6};
        int i3 = maxProduct(nums3);
        System.out.println(i3);
    }
}
