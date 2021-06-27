package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglei
 * @date 2021/6/27 22:50
 * <p>
 * 题号：#149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。
 * 求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * 提示：
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 */
public class MaxPoints_149 {
    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (result >= n - i || result > n / 2) {
                break;
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }

                    int temp = temp(Math.abs(x), Math.abs(y));
                    x /= temp;
                    y /= temp;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                max = Math.max(max, value + 1);
            }
            result = Math.max(result, max);
        }
        return result;
    }

    private static int temp(int a, int b) {
        return b != 0 ? temp(b, a % b) : a;
    }

    public static void main(String[] args) {
        int[][] points_1 = {{1, 1}, {2, 2}, {3, 3}};
        int i1 = maxPoints(points_1);
        System.out.println(i1);

        int[][] points_2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int i2 = maxPoints(points_2);
        System.out.println(i2);
    }
}
