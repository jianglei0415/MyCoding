package sort;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2021/4/12 22:02
 * <p>
 * 题号：#179. 最大数
 * <p>
 * 给定一组非负整数 nums，
 * 重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumber_179 {
    public static String largestNumber(int[] nums) {
        String[] stringNum = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNum[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNum, (a, b) -> (b + a).compareTo(a + b));

        if (stringNum[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stringNum) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 方法二：快排思想
     */
    public static String largestNumber_2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = nums[start];
        int index = start;

        for (int i = start + 1; i <= end; i++) {
            long x = 10, y = 10;
            while (nums[i] >= x) {
                x *= 10;
            }
            while (pivot >= y) {
                y *= 10;
            }

            if (nums[i] * y + pivot > nums[i] + pivot * x) {
                index += 1;
                swap(nums, index, i);
            }
        }
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums_1 = {10, 2};
        String s1 = largestNumber(nums_1);
        System.out.println(s1);

        int[] nums_2 = {3, 30, 34, 5, 9};
        String s2 = largestNumber_2(nums_2);
        System.out.println(s2);

        int[] nums_3 = {1};
        String s3 = largestNumber(nums_3);
        System.out.println(s3);

        int[] nums_4 = {10};
        String s4 = largestNumber(nums_4);
        System.out.println(s4);
    }
}
