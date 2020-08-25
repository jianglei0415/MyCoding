package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/8/25 8:23
 * <p>
 * 题号：#491. 递增子序列
 * <p>
 * 给定一个整型数组,
 * 你的任务是找到所有该数组的递增子序列，
 * 递增子序列的长度至少是2。
 * <p>
 * 示例:
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * <p>
 * 说明:
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class FindSubsequences_491 {
    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, -1, new ArrayList<>());
        return result;
    }

    private static void dfs(int[] nums, int index, ArrayList<Integer> list) {
        if (list.size() > 1) {
            result.add(new ArrayList<>(list));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (index == -1 || nums[i] >= nums[index]) {
                list.add(nums[i]);
                dfs(nums, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> subsequences = findSubsequences(nums);
        System.out.println(subsequences);
    }
}
