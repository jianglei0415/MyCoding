package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/2/14 22:02
 * <p>
 * 题号：#167 两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照升序排列 的有序数组，
 * 找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，
 * 其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。
 * 因此 index1 = 1, index2 = 2 。
 */
public class TwoSum_167 {
    private static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                if (i + 1 > map.get(temp) + 1) {
                    return new int[]{map.get(temp) + 1, i + 1};
                }
                return new int[]{i + 1, map.get(temp) + 1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{};
    }

    private static int[] twoSum1(int[] numbers, int target) {
        if (numbers == null) {
            return new int[]{};
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = (numbers[left] + numbers[right]);
            if (temp == target) {
                return new int[]{left + 1, right + 1};
            } else if (temp > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum1(numbers, target);
        System.out.println(Arrays.toString(ints));
    }
}
