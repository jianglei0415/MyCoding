package dp;

/**
 * @author jianglei
 * @date 2020/10/11 18:09
 * <p>
 * 题号：#416. 分割等和子集
 * <p>
 * 给定一个只包含正整数的非空数组。
 * 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class CanPartition_416 {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums_1 = {1, 5, 11, 5};
        boolean b1 = canPartition(nums_1);
        System.out.println(b1);

        int[] nums_2 = {1, 2, 3, 5};
        boolean b2 = canPartition(nums_2);
        System.out.println(b2);
    }
}















