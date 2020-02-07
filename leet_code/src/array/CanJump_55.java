package array;

/**
 * @author: jianglei
 * @date: 2020/2/7 11:
 * <p>
 * 题号：#55 跳跃游戏
 * <p>
 * 给定一个非负整数数组，
 * 你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * <p>
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * <p>
 * 解释:
 * 无论怎样，
 * 你总会到达索引为 3 的位置。
 * 但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 */
public class CanJump_55 {
    private static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int zeroCount = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (nums[i] > zeroCount) {
                    zeroCount = 0;
                } else {
                    zeroCount++;
                }
            }
        }
        if (zeroCount > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        boolean jump1 = canJump(nums1);
        System.out.println(jump1);

        int[] nums2 = {3, 2, 1, 0, 4};
        boolean jump2 = canJump(nums2);
        System.out.println(jump2);

        int[] nums3 = {2, 0, 2};
        boolean jump3 = canJump(nums3);
        System.out.println(jump3);
    }
}
