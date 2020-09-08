package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/8 8:39
 * <p>
 * 题号：#77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combine_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, n, k, 1, new ArrayList<>());
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(result, n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combine = combine(n, k);
        System.out.println(combine);
    }
}
