package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/2/21 23:11
 * <p>
 * 题号：#442 数组中重复的数据
 * <p>
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）,
 * 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 */
public class FindDuplicates_442 {
    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }
}
