package array;

import java.util.*;

/**
 * @author: jianglei
 * @date: 2020/2/7 13:58
 * <p>
 * 题号：#56 合并区间
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge_56 {
    private static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[0][]);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while ((i < intervals.length - 1) && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            result.add(new int[]{left, right});
            i++;
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge1 = merge(intervals1);
        System.out.println(Arrays.deepToString(merge1));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] merge2 = merge(intervals2);
        System.out.println(Arrays.deepToString(merge2));
    }
}
