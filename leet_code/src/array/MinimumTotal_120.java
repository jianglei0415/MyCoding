package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/10 23:17
 * <p>
 * 题号：#120 三角形最小路径和
 * <p>
 * 给定一个三角形，
 * 找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，
 * 那么你的算法会很加分。
 */
public class MinimumTotal_120 {
    private static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        //获取最后一行的数据存入dp数组中
        List<Integer> row = triangle.get(n - 1);
        for (int i = 0; i < row.size(); i++) {
            dp[i] = row.get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            //从倒数第二行开始
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                //dp值刷新为当前值加上下一行相邻数据之间的最小值
                dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        //此时dp[0]即为最小路径和
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int i = minimumTotal(triangle);
        System.out.println(i);
    }
}
