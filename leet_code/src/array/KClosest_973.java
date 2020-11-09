package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jianglei
 * @date 2020/11/9 19:07
 * <p>
 * 题号：#973. 最接近原点的 K 个点
 * <p>
 * 我们有一个由平面上的点组成的列表 points。
 * 需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，
 * 答案确保是唯一的。
 * <p>
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * <p>
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 * <p>
 * 提示：
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosest_973 {
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < K; i++) {
            queue.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; i++) {
            int temp = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (temp < queue.peek()[0]) {
                queue.poll();
                queue.offer(new int[]{temp, i});
            }
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = points[queue.poll()[1]];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points_1 = {
                {1, 3}, {-2, 2}
        };
        int k_1 = 1;
        int[][] ints1 = kClosest(points_1, k_1);
        System.out.println(Arrays.deepToString(ints1));

        int[][] points_2 = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k_2 = 2;
        int[][] ints2 = kClosest(points_2, k_2);
        System.out.println(Arrays.deepToString(ints2));
    }
}
