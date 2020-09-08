package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/8 14:04
 * <p>
 * 题号：#46. 全排列
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permute_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(result, list, nums.length, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> list, int length, int first) {
        if (first == length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = first; i < length; i++) {
            Collections.swap(list, first, i);
            backtrack(result, list, length, first + 1);
            Collections.swap(list, first, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
