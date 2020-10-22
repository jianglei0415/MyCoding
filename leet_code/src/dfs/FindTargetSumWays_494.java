package dfs;

/**
 * @author jianglei
 * @date 2020/10/22 19:50
 * <p>
 * 题号：#494. 目标和
 * <p>
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 * <p>
 * 提示：
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class FindTargetSumWays_494 {
    private static int result = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return result;
    }

    private static void dfs(int[] nums, int S, int start, int sum) {
        if (start == nums.length) {
            if (sum == S) {
                result++;
            }
        } else {
            dfs(nums, S, start + 1, sum + nums[start]);
            dfs(nums, S, start + 1, sum - nums[start]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        int targetSumWays = findTargetSumWays(nums, S);
        System.out.println(targetSumWays);
    }
}
