package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/12 20:00
 * <p>
 * 题号：#163 缺失的区间
 * <p>
 * 给定一个排序的整数数组 nums ，
 * 其中元素的范围在 闭区间 [lower, upper] 当中，
 * 返回不包含在数组中的缺失区间。
 * <p>
 * 示例:
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 */
public class FindMissingRanges_163 {
    private static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(range(lower, upper));
            return result;
        }
        if (lower < nums[0]) {
            result.add(range(lower, nums[0] - 1));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 < nums[i + 1]) {
                result.add(range(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            result.add(range(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    private static String range(int lower, int upper) {
        if (lower == upper) {
            return Integer.toString(lower);
        }
        return lower + "->" + upper;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> missingRanges = findMissingRanges(nums, lower, upper);
        System.out.println(missingRanges);
    }
}
