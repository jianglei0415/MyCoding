package sort;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/11/17 9:07
 * <p>
 * 题号：#1030. 距离顺序排列矩阵单元格
 * <p>
 * 给出 R 行 C 列的矩阵，
 * 其中的单元格的整数坐标为 (r, c)，
 * 满足 0 <= r < R 且 0 <= c < C。
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 返回矩阵中的所有单元格的坐标，
 * 并按到 (r0, c0) 的距离从最小到最大的顺序排，
 * 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，
 * |r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 * 示例 1：
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * <p>
 * 示例 2：
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * <p>
 * 示例 3：
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * <p>
 * 提示：
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */
public class AllCellsDistOrder_1030 {
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                list.add(new int[]{i, j});
            }
        }

        Collections.sort(list, (o1, o2) -> {
            int temp1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int temp2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return temp1 - temp2;
        });

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int R_1 = 1, C_1 = 2, r0_1 = 0, c0_1 = 0;
        int[][] ints1 = allCellsDistOrder(R_1, C_1, r0_1, c0_1);
        System.out.println(Arrays.deepToString(ints1));

        int R_2 = 2, C_2 = 2, r0_2 = 0, c0_2 = 1;
        int[][] ints2 = allCellsDistOrder(R_2, C_2, r0_2, c0_2);
        System.out.println(Arrays.deepToString(ints2));

        int R_3 = 2, C_3 = 3, r0_3 = 1, c0_3 = 2;
        int[][] ints3 = allCellsDistOrder(R_3, C_3, r0_3, c0_3);
        System.out.println(Arrays.deepToString(ints3));
    }
}