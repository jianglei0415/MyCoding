package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/2/20 0:14
 * <p>
 * 题号：#219  存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数 k，
 * 判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate_219 {
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        boolean b1 = containsNearbyDuplicate(nums1, k1);
        System.out.println(b1);

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        boolean b2 = containsNearbyDuplicate(nums2, k2);
        System.out.println(b2);

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        boolean b3 = containsNearbyDuplicate(nums3, k3);
        System.out.println(b3);
    }
}
