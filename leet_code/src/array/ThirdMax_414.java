package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/2/21 22:43
 * <p>
 * 题号：#414 第三大的数
 * <p>
 * 给定一个非空数组，
 * 返回此数组中第三大的数。
 * 如果不存在，
 * 则返回数组中最大的数。
 * 要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 * <p>
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * <p>
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class ThirdMax_414 {
    private static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        return (third == Long.MIN_VALUE || third == second) ? (int) first : (int) third;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1};
        int i1 = thirdMax(nums1);
        System.out.println(i1);

        int[] nums2 = {1, 2};
        int i2 = thirdMax(nums2);
        System.out.println(i2);

        int[] nums3 = {2, 2, 3, 1};
        int i3 = thirdMax(nums3);
        System.out.println(i3);
    }
}