package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/5 15:09
 * <p>
 * 题号：#35 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，
 * 在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert_35 {
    private static int searchInsert(int[] nums, int target) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        int left = 0;
        int right = nums.length;
        if (nums[right - 1] < target) {
            return right;
        }
        if (nums[left] > target) {
            return left;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target1 = 5;
        int i1 = searchInsert(nums, target1);
        System.out.println(i1);

        int target2 = 2;
        int i2 = searchInsert(nums, target2);
        System.out.println(i2);

        int target3 = 7;
        int i3 = searchInsert(nums, target3);
        System.out.println(i3);

        int target4 = 0;
        int i4 = searchInsert(nums, target4);
        System.out.println(i4);
    }
}
