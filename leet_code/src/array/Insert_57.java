package array;

import java.util.*;

/**
 * @author: jianglei
 * @date: 2020/2/7 16:01
 * <p>
 * 题号：#57 插入区间
 * <p>
 * 给出一个无重叠的 ，
 * 按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，
 * 你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * <p>
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * <p>
 * 解释:
 * 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Insert_57 {
    private static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        int insertPos = 0;
        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                result.add(new int[]{interval[0], interval[1]});
                insertPos++;
            } else if (newInterval[0] > interval[1]) {
                result.add(new int[]{interval[0], interval[1]});
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(insertPos, new int[]{newInterval[0], newInterval[1]});
        int[][] ints = result.toArray(new int[0][]);
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return ints;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {
                {1, 3}, {6, 9}
        };
        int[] newInterval1 = {2, 5};
        int[][] insert1 = insert(intervals1, newInterval1);
        System.out.println(Arrays.deepToString(insert1));

        int[][] intervals2 = {
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        int[] newInterval2 = {4, 8};
        int[][] insert2 = insert(intervals2, newInterval2);
        System.out.println(Arrays.deepToString(insert2));
    }
}
