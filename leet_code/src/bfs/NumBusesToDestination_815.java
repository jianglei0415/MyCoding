package bfs;

import java.util.*;

/**
 * @author jianglei
 * @date 2021/6/29 20:27
 * <p>
 * 题号：#815. 公交路线
 * <p>
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * <p>
 * 示例 2：
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 */
public class NumBusesToDestination_815 {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[][] used = new boolean[n][n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = map.getOrDefault(site, new ArrayList<>());
                for (int l : list) {
                    used[i][l] = used[l][i] = true;
                }
                list.add(i);
                map.put(site, list);
            }
        }

        int[] flag = new int[n];
        Arrays.fill(flag, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int bus : map.getOrDefault(source, new ArrayList<>())) {
            flag[bus] = 1;
            queue.offer(bus);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < n; i++) {
                if (used[x][i] && flag[i] == -1) {
                    flag[i] = flag[x] + 1;
                    queue.offer(i);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int bus : map.getOrDefault(target, new ArrayList<>())) {
            if (flag[bus] != -1) {
                result = Math.min(result, flag[bus]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        int[][] routes_1 = {{1, 2, 7}, {3, 6, 7}};
        int i1 = numBusesToDestination(routes_1, 1, 6);
        System.out.println(i1);

        int[][] routes_2 = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int i2 = numBusesToDestination(routes_2, 15, 12);
        System.out.println(i2);
    }
}
