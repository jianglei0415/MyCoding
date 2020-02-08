package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/2/8 10:39
 * <p>
 * 题号：#75 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，
 * 一共 n 个元素的数组，
 * 原地对它们进行排序，
 * 使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors_75 {
    private static void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            if (nums[i] == 1) {
                oneCount++;
            }
            if (nums[i] == 2) {
                twoCount++;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            nums[i] = 0;
        }
        for (int i = zeroCount; i < zeroCount + oneCount; i++) {
            nums[i] = 1;
        }
        for (int i = zeroCount + oneCount; i < zeroCount + oneCount + twoCount; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
