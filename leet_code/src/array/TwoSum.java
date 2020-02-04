package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/2/3 21:52
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    //方法1：暴力法
    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            return result;
        }
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (target - nums[i] == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                } else {
                    continue;
                }
            }
        }
        return result;
    }

    //方法2：Map集合
    private static int[] twoSum1(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> result = new HashMap<>(2);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (result.containsKey(temp)) {
                return new int[]{result.get(temp), i};
            }
            result.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum1(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
