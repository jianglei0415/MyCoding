package array;

import java.util.Arrays;

/**
 * @author: jianglei
 * @date: 2020/2/7 22:53
 * <p>
 * 题号：#66 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，
 * 在该数的基础上加一。
 * 最高位数字存放在数组的首位，
 * 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，
 * 这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne_66 {
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;

            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        int[] ints1 = plusOne(digits1);
        System.out.println(Arrays.toString(ints1));

        int[] digits2 = {4, 3, 2, 1};
        int[] ints2 = plusOne(digits2);
        System.out.println(Arrays.toString(ints2));

        int[] digits3 = {9, 9, 9};
        int[] ints3 = plusOne(digits3);
        System.out.println(Arrays.toString(ints3));
    }
}
