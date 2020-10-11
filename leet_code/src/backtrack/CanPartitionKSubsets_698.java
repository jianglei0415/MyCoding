package backtrack;

/**
 * @author jianglei
 * @date 2020/10/11 20:22
 * <p>
 * 题号：#698. 划分为k个相等的子集
 * <p>
 * 给定一个整数数组  nums 和一个正整数 k，
 * 找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 提示：
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 */
public class CanPartitionKSubsets_698 {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }

        int target = sum / k;
        if (sum % k != 0 || maxNum > target) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        return backtrack(nums, k, target, 0, 0, used);
    }

    private static boolean backtrack(int[] nums, int k, int target, int curr, int start, boolean[] used) {
        if (k == 0) {
            return true;
        }

        if (curr == target) {
            return backtrack(nums, k - 1, target, 0, 0, used);
        }

        for (int i = start; i < nums.length; i++) {
            if (!used[i] && curr + nums[i] <= target) {
                used[i] = true;
                if (backtrack(nums, k, target, curr + nums[i], i + 1, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean b = canPartitionKSubsets(nums, k);
        System.out.println(b);
    }
}
