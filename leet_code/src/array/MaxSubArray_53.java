package array;

/**
 * @author: jianglei
 * @date: 2020/2/6 22:31
 * <p>
 * 题号：#53 最大子序和
 * <p>
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * <p>
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray_53 {
    //解法一：贪心算法
    private static int maxSubArray1(int[] nums) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        int currSum = nums[0];
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            result = Math.max(result, currSum);
        }
        return result;
    }

    //解法二：动态规划
    private static int maxSubArray2(int[] nums) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            result = Math.max(nums[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i1 = maxSubArray1(nums);
        System.out.println(i1);

        int i2 = maxSubArray2(nums);
        System.out.println(i2);
    }
}
