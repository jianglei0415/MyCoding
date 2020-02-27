package offer;

import java.util.Map;

/**
 * @author jianglei
 * @date 2020/2/27 23:38
 * <p>
 * 题号：面试题42. 连续子数组的最大和
 * <p>
 * 输入一个整型数组，
 * 数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * <p>
 * 注意：本题与主站 53 题相同：
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray_42 {
    private static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int result = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            result = Math.max(result, curr);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
}
