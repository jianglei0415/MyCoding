package array;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/10/26 19:40
 * <p>
 * 题号：#1365. 有多少小于当前数字的数字
 * <p>
 * 给你一个数组 nums，对于其中每个元素 nums[i]，
 * 请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，
 * 其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * <p>
 * 示例 2：
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class SmallerNumbersThanCurrent_1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] temp = new int[101];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            temp[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            temp[i] += temp[i - 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = nums[i] == 0 ? 0 : temp[nums[i] - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums_1 = {8, 1, 2, 2, 3};
        int[] ints1 = smallerNumbersThanCurrent(nums_1);
        System.out.println(Arrays.toString(ints1));

        int[] nums_2 = {6, 5, 4, 8};
        int[] ints2 = smallerNumbersThanCurrent(nums_2);
        System.out.println(Arrays.toString(ints2));

        int[] nums_3 = {7, 7, 7, 7};
        int[] ints3 = smallerNumbersThanCurrent(nums_3);
        System.out.println(Arrays.toString(ints3));
    }
}
