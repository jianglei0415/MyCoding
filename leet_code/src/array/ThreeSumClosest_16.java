package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/4 17:21
 * <p>
 * 题号：#16 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest_16 {
    private static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int temp = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - tmp) < Math.abs(target - temp)) {
                    temp = tmp;
                } else if (tmp > target) {
                    right--;
                } else if (tmp < target) {
                    left++;
                } else {
                    return temp;
                }
                result = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest(nums, target);
        System.out.println(result);
    }
}
