package stack;

/**
 * @author jianglei
 * @date 2020/3/6 14:31
 * <p>
 * 题号：#456. 132模式
 * <p>
 * 给定一个整数序列：a1, a2, ..., an，
 * 一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，
 * 当给定有 n 个数字的序列时，
 * 验证这个序列中是否含有132模式的子序列。
 * 注意：n 的值小于15000。
 * <p>
 * 示例1:
 * 输入: [1, 2, 3, 4]
 * 输出: False
 * 解释: 序列中不存在132模式的子序列。
 * <p>
 * 示例 2:
 * 输入: [3, 1, 4, 2]
 * 输出: True
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * <p>
 * 示例 3:
 * 输入: [-1, 3, 2, 0]
 * 输出: True
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 */
public class Find132pattern_456 {
    private static boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > min && nums[i] > nums[j]) {
                        return true;
                    }
                }
            } else {
                min = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        boolean pattern1 = find132pattern(nums1);
        System.out.println(pattern1);

        int[] nums2 = {3, 1, 4, 2};
        boolean pattern2 = find132pattern(nums2);
        System.out.println(pattern2);

        int[] nums3 = {-1, 3, 2, 0};
        boolean pattern3 = find132pattern(nums3);
        System.out.println(pattern3);

        int[] nums4 = {3, 5, 0, 3, 4};
        boolean pattern4 = find132pattern(nums4);
        System.out.println(pattern4);
    }
}
