package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/2/20 20:42
 * <p>
 * 题号：#228 汇总区间
 * <p>
 * 给定一个无重复元素的有序整数数组，
 * 返回数组区间范围的汇总。
 * <p>
 * 示例 1:
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间;
 *  4,5 可组成一个连续的区间。
 * <p>
 * 示例 2:
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间;
 *  8,9 可组成一个连续的区间。
 */
public class SummaryRanges_228 {
    private static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                result.add(nums[i] + "");
            } else {
                result.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        List<String> list1 = summaryRanges(nums1);
        System.out.println(list1);

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        List<String> list2 = summaryRanges(nums2);
        System.out.println(list2);
    }
}
