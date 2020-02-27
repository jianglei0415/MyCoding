package offer;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/2/27 23:45
 * <p>
 * 题号：面试题21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Exchange_21 {
    private static int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                int temp = nums[i];
                nums[i] = nums[a];
                nums[a++] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] exchange = exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }
}
