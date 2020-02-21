package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/2/20 21:08
 * <p>
 * 题号：#229 求众数 II
 * <p>
 * 给定一个大小为 n 的数组，
 * 找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 说明: 要求算法的时间复杂度为 O(n)，
 * 空间复杂度为 O(1)。
 * <p>
 * 示例 1:、
 * 输入: [3,2,3]
 * 输出: [3]
 * <p>
 * 示例 2:
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class MajorityElement_229 {
    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                result.add(key);
            }
        }
        return result;
    }

    private static List<Integer> majorityElement1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int chooseA = nums[0];
        int chooseB = nums[0];
        int countA = 0;
        int countB = 0;
        for (int num : nums) {
            if (num == chooseA) {
                countA++;
                continue;
            }
            if (num == chooseB) {
                countB++;
                continue;
            }
            if (countA == 0) {
                chooseA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                chooseB = num;
                countB++;
                continue;
            }
            countA--;
            countB--;
        }
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == chooseA) {
                countA++;
            } else if (num == chooseB) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            result.add(chooseA);
        }
        if (countB > nums.length / 3) {
            result.add(chooseB);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        List<Integer> list1 = majorityElement1(nums1);
        System.out.println(list1);

        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> list2 = majorityElement1(nums2);
        System.out.println(list2);
    }
}
