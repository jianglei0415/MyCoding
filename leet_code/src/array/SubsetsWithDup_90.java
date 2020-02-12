package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/9 0:04
 * <p>
 * 题号：#90 子集 II
 * <p>
 * 给定一个可能包含重复元素的整数数组 nums，
 * 返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsWithDup_90 {
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, nums, temp, 0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp));
        if(start>nums.length-1){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(result, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        System.out.println(lists);
    }
}
