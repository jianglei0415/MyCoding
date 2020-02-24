package array;

/**
 * @author jianglei
 * @date 2020/2/24 23:32
 * <p>
 * 题号：#457 环形数组循环
 * <p>
 * 给定一个含有正整数和负整数的环形数组 nums。
 * 如果某个索引中的数 k 为正数，
 * 则向前移动 k 个索引。
 * 相反，如果是负数 (-k)，
 * 则向后移动 k 个索引。
 * 因为数组是环形的，
 * 所以可以假设最后一个元素的下一个元素是第一个元素，
 * 而第一个元素的前一个元素是最后一个元素。
 * 确定 nums 中是否存在循环（或周期）。
 * 循环必须在相同的索引处开始和结束并且循环长度 > 1。
 * 此外，一个循环中的所有运动都必须沿着同一方向进行。
 * 换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 * <p>
 * 示例 1：
 * 输入：[2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，
 * 按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * <p>
 * 示例 2：
 * 输入：[-1,2]
 * 输出：false
 * 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，
 * 因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * <p>
 * 示例 3:
 * 输入：[-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，
 * 因为按索引 1 -> 2 的运动是向前的运动，
 * 而按索引 2 -> 1 的运动是向后的运动。
 * 一个循环中的所有运动都必须沿着同一方向进行。
 * <p>
 * 提示：
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 0 ≤ nums.length ≤ 5000
 * <p>
 * 进阶：
 * 你能写出时间时间复杂度为 O(n) 和额外空间复杂度为 O(1) 的算法吗？
 */
public class CircularArrayLoop_457 {
    private static boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int k = next(nums, i);
            while (nums[i] * nums[j] > 0 && nums[i] * nums[k] > 0 && nums[i] * nums[next(nums, k)] > 0) {
                if (j == k) {
                    if (j == next(nums, j)) {
                        break;
                    }
                    return true;
                }
                j = next(nums, j);
                k = next(nums, next(nums, k));
            }
        }
        return false;
    }

    private static int next(int[] nums, int i) {
        int next = i + nums[i];
        if (next >= 0) {
            return next % nums.length;
        } else {
            return nums.length + next % nums.length;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, -1, 1, 2, 2};
        boolean b1 = circularArrayLoop(nums1);
        System.out.println(b1);

        int[] nums2 = {-1, 2};
        boolean b2 = circularArrayLoop(nums2);
        System.out.println(b2);

        int[] nums3 = {-2, 1, -1, -2, -2};
        boolean b3 = circularArrayLoop(nums3);
        System.out.println(b3);
    }
}
