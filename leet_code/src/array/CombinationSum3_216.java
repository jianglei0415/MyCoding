package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/14 23:36
 * <p>
 * 题号；#216 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，
 * 并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3_216 {
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(k, n, result, temp, 1);
        return result;
    }

    private static void dfs(int k, int n, List<List<Integer>> result, List<Integer> temp, int start) {
        if (n == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
        } else if (temp.size() == k || n == 0) {
            return;
        } else {
            for (int i = start; i <= 9 && n - i >= 0; i++) {
                temp.add(i);
                dfs(k, n - i, result, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int k1 = 3, n1 = 7;
        List<List<Integer>> lists1 = combinationSum3(k1, n1);
        System.out.println(lists1);

        int k2 = 3, n2 = 9;
        List<List<Integer>> lists2 = combinationSum3(k2, n2);
        System.out.println(lists2);
    }
}
