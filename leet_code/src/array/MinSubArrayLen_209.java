package array;

/**
 * @author jianglei
 * @date 2020/2/19 23:44
 * <p>
 * 题号：#209 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法,
 * 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen_209 {
    /**
     * 解法一：暴力破解
     */
    private static int minSubArrayLen1(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            int sum = 0;
            while (start < nums.length) {
                sum += nums[start];
                start++;
                if (sum >= s) {
                    min = Math.min(min, start - i);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static int minSubArrayLen2(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            end++;
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen2(s, nums);
        System.out.println(i);
    }
}
