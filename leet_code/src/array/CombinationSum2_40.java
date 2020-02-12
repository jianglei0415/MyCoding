package array;

import java.util.*;

/**
 * @author: jianglei
 * @date: 2020/2/5 20:31
 * <p>
 * 题号：#40 组合总和II
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSum2_40 {
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || target < 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] candidates, int target, List<Integer> temp, int nextIndex) {
        if (target == 0) {
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        }
        if (nextIndex >= candidates.length || candidates[nextIndex] > target) {
            return;
        }
        for (int i = nextIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            List<Integer> list = new ArrayList<>(temp);
            list.add(candidates[i]);
            dfs(result, candidates, target - candidates[i],list, ++nextIndex);
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        List<List<Integer>> lists1 = combinationSum2(candidates1, target1);
        System.out.println(lists1.toString());

        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        List<List<Integer>> lists2 = combinationSum2(candidates2, target2);
        System.out.println(lists2.toString());

        int[] candidates3 = {14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12};
        int target3 = 27;
        List<List<Integer>> lists3 = combinationSum2(candidates3, target3);
        System.out.println(lists3);
    }
}
