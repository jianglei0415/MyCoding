package array;

/**
 * @author: jianglei
 * @date: 2020/2/8 22:23
 * <p>
 * 题号：#84 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，
 * 用来表示柱状图中各个柱子的高度。
 * 每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleArea_84 {
    private static int largestRectangleArea(int[] heights) {
        int result = 0;
        int len, wid;
        for (int i = 0; i < heights.length; i++) {
            if (i != heights.length - 1 && heights[i] <= heights[i + 1]) {
                continue;
            }
            wid = heights[i];
            for (int j = i; j >= 0; j--) {
                len = i - j + 1;
                wid = Math.min(wid, heights[j]);
                result = Math.max(result, len * wid);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }
}
