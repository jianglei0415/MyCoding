package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/18 22:45
 * <p>
 * 题号：#47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermuteUnique_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, result, vis, 0, perm);
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, boolean[] vis, int start, List<Integer> perm) {
        if (start == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, result, vis, start + 1, perm);
            vis[i] = false;
            perm.remove(start);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }
}
