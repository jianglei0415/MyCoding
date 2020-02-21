package array;

/**
 * @author jianglei
 * @date 2020/2/20 22:23
 * <p>
 * 题号：#268 缺失数字
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，
 * 找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * <p>
 * 说明:
 * 你的算法应具有线性时间复杂度。
 * 你能否仅使用额外常数空间来实现?
 */
public class MissingNumber_268 {
    private static int missingNumber(int[] nums) {
        int result = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            result -= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int i1 = missingNumber(nums1);
        System.out.println(i1);

        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int i2 = missingNumber(nums2);
        System.out.println(i2);
    }
}
