package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/10 23:14
 * <p>
 * 题号：#119 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，
 * 其中 k ≤ 33，
 * 返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，
 * 每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GetRow_119 {
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result.add(1);
                } else {
                    result.add(temp.get(j - 1) + temp.get(j));
                }
            }
            temp = result;
        }
        return result;
    }

    private static List<Integer> getRow1(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long pre = 1;
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            long cur = pre * (rowIndex - i + 1) / i;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> row1 = getRow(rowIndex);
        List<Integer> row2 = getRow1(rowIndex);
        System.out.println(row1);
        System.out.println(row2);
    }
}
