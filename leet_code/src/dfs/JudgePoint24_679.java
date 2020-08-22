package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/3/7 13:16
 * <p>
 * 题号：#679.24 点游戏
 * <p>
 * 你有 4 张写有 1 到 9 数字的牌。
 * 你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * <p>
 * 示例 1:
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * <p>
 * 示例 2:
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * <p>
 * 注意:
 * 1.除法运算符 / 表示实数除法，而不是整数除法。
 * 例如 4 / (1 - 2/3) = 12 。
 * 2.每个运算符对两个数进行运算。
 * 特别是我们不能用 - 作为一元运算符。
 * 例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 3.你不能将数字连接在一起。
 * 例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 */
public class JudgePoint24_679 {
    private static final int TARGET = 24;
    private static final double EPSILON = 1e-6;
    private static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    private static boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }

        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }

                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }

                        if (solve(list2)) {
                            return true;
                        }

                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 8, 7};
        boolean b1 = judgePoint24(nums1);
        System.out.println(b1);

        int[] nums2 = {1, 2, 1, 2};
        boolean b2 = judgePoint24(nums2);
        System.out.println(b2);
    }
}
