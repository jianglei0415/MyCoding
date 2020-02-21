package array;

/**
 * @author jianglei
 * @date 2020/2/20 23:04
 * <p>
 * 题号：#287 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，
 * 其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，
 * 找出这个重复的数。
 * <p>
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * <p>
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class FindDuplicate_287 {
    private static int findDuplicate(int[] nums) {
        int result = 0;
        if (nums == null) {
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int duplicate1 = findDuplicate(nums1);
        System.out.println(duplicate1);

        int[] nums2 = {3, 1, 3, 4, 2};
        int duplicate2 = findDuplicate(nums2);
        System.out.println(duplicate2);
    }
}
