package array;

/**
 * @author: jianglei
 * @date: 2020/2/14 22:17
 * <p>
 * 题号：#169 多数元素
 * <p>
 * 给定一个大小为 n 的数组，
 * 找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，
 * 并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement_169 {
    private static int majorityElement(int[] nums) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }
            count += (nums[i] == result) ? +1 : -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int i1 = majorityElement(nums1);
        System.out.println(i1);

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int i2 = majorityElement(nums2);
        System.out.println(i2);
    }
}
