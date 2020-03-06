package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/3/6 13:56
 * <p>
 * 题号：#面试题57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，
 * 输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * 1 <= target <= 10^5
 */
public class FindContinuousSequence_57_II {
    private static int[][] findContinuousSequence(int target) {
        int min = 1;
        int max = 2;
        int sum = min + max;
        List<int[]> result = new ArrayList<>();
        while (min < max && max < target) {
            if (sum < target) {
                max++;
                sum += max;
            } else if (sum > target) {
                sum -= min;
                min++;
            } else if (sum == target) {
                int[] temp = new int[max - min + 1];
                int j = min;
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = j++;
                }
                result.add(temp);
                sum -= min;
                min++;
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int target1 = 9;
        int[][] continuousSequence1 = findContinuousSequence(target1);
        System.out.println(Arrays.deepToString(continuousSequence1));

        int target2 = 15;
        int[][] continuousSequence2 = findContinuousSequence(target2);
        System.out.println(Arrays.deepToString(continuousSequence2));
    }
}
