package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/10/14 23:20
 * <p>
 * 题号：#349. 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        int[] temp = new int[nums2.length];
        int index = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                temp[index++] = num;
                set.remove(num);
            }
        }
        return Arrays.copyOfRange(temp, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1_1 = {1, 2, 2, 1};
        int[] nums2_1 = {2, 2};
        int[] intersect1 = intersection(nums1_1, nums2_1);
        System.out.println(Arrays.toString(intersect1));

        int[] nums1_2 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};
        int[] intersect2 = intersection(nums1_2, nums2_2);
        System.out.println(Arrays.toString(intersect2));
    }
}
