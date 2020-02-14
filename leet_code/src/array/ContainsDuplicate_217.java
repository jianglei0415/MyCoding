package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: jianglei
 * @date: 2020/2/14 23:17
 * <p>
 * 题号：#217 存在重复元素
 * <p>
 * 给定一个整数数组，
 * 判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，
 * 函数返回 true。
 * 如果数组中每个元素都不相同，
 * 则返回 false。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate_217 {
    private static boolean containsDuplicate(int[] nums) {
        boolean result = false;
        if (nums == null) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() == nums.length) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        boolean b1 = containsDuplicate(nums1);
        System.out.println(b1);

        int[] nums2 = {1, 2, 3, 4};
        boolean b2 = containsDuplicate(nums2);
        System.out.println(b2);

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean b3 = containsDuplicate(nums3);
        System.out.println(b3);
    }
}
