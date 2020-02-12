package array;

import java.util.*;

/**
 * @author: jianglei
 * @date: 2020/2/5 15:24
 * <p>
 * 题号：#39 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum_39 {
    private static List<List<Integer>>
    combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        for (int i = 1; i <= target; i++) {
            map.put(i, new HashSet<>());
            for (int j = 0; j < candidates.length && candidates[j] <= target; j++) {
                if (i == candidates[j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(candidates[j]);
                    map.get(i).add(list);
                } else if (i > candidates[j]) {
                    int temp = i - candidates[j];
                    for (Iterator iterator = map.get(temp).iterator(); iterator.hasNext(); ) {
                        List list = (List) iterator.next();
                        List tmp = new ArrayList();
                        tmp.addAll(list);
                        tmp.add(candidates[j]);
                        Collections.sort(tmp);
                        map.get(i).add(tmp);
                    }
                }
            }
        }
        result.addAll(map.get(target));
        return result;
    }

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> lists1 = combinationSum(candidates1, target1);
        System.out.println(lists1.toString());

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> lists2 = combinationSum(candidates2, target2);
        System.out.println(lists2.toString());
    }
}
