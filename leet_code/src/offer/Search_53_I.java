package offer;

/**
 * @author jianglei
 * @date 2021/6/6 17:22
 * <p>
 * 题号：#剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Search_53_I {
    public static int search(int[] nums, int target) {
        return temp(nums, target) - temp(nums, target - 1);
    }

    private static int temp(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums_1 = {5,7,7,8,8,10};
        int i1 = search(nums_1, 8);
        System.out.println(i1);

        int i2 = search(nums_1, 6);
        System.out.println(i2);
    }
}
