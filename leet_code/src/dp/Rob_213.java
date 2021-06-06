package dp;

/**
 * @author jianglei
 * @date 2021/6/6 18:29
 * <p>
 * 题号：#213. 打家劫舍 II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class Rob_213 {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(solution(nums, 0, nums.length - 2), solution(nums, 1, nums.length -1));
    }

    private static int solution(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(first, nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = nums[i];
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums_1 = {2,3,2};
        int rob1 = rob(nums_1);
        System.out.println(rob1);

        int[] nums_2 = {1,2,3,1};
        int rob2 = rob(nums_2);
        System.out.println(rob2);

        int[] nums_3 = {0};
        int rob3 = rob(nums_3);
        System.out.println(rob3);
    }
}
