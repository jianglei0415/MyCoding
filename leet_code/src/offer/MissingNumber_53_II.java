package offer;

/**
 * @author jianglei
 * @date 2021/6/6 17:04
 * <p>
 * 题号：#剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 限制：
 * 1 <= 数组长度 <= 10000
 */
public class MissingNumber_53_II {
    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length ;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums_1 = {0, 1, 3};
        int i1 = missingNumber(nums_1);
        System.out.println(i1);

        int[] nums_2 = {0,1,2,3,4,5,6,7,9};
        int i2 = missingNumber(nums_2);
        System.out.println(i2);
    }
}
