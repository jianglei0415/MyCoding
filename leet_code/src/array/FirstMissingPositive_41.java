package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/6 0:31
 * <p>
 * 题号：#41 缺失的第一个正数
 * <p>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 说明:
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive_41 {
    private static int firstMissingPositive(int[] nums) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                break;
            }
        }
        if (count == 0) {
            return 1;
        }
        if (nums.length == 1) {
            return 2;
        }
        //将所有小于等于0或者大于nums.length的数全部置为1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            //遍历取出数组中的值
            int a = Math.abs(nums[i]);
            //如果取出的值为n，将0处的值置为负数，否则将对应的下标为的值置为负数
            if (a == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }
        System.out.println(Arrays.toString(nums));

        //从1开始取值，为正数的就取下标值为缺失的最小正整数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        //如果取完整个数组都没发现大于0的数，在判断0处的数是否大于0
        if (nums[0] > 0) {
            return nums.length;
        }
        //全部没有的话，表示最小值为n+1
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        System.out.println(Arrays.toString(nums1));
        int i1 = firstMissingPositive(nums1);
        System.out.println(i1);

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(Arrays.toString(nums2));
        int i2 = firstMissingPositive(nums2);
        System.out.println(i2);

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(Arrays.toString(nums3));
        int i3 = firstMissingPositive(nums3);
        System.out.println(i3);
    }
}
