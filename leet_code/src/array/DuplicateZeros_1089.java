package array;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/8/8 17:07
 * <p>
 * 题号：#1089 复写零
 * <p>
 * 给你一个长度固定的整数数组 arr，
 * 请你将该数组中出现的每个零都复写一遍，
 * 并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 示例 1：
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * 提示：
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeros_1089 {
    public static void duplicateZeros1(int[] arr) {
        int i = 0, j = 0, n = arr.length;
        while (j < n) {
            if (arr[i] == 0) {
                ++j;
            }
            ++i;
            ++j;
        }
        --i;
        --j;
        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0) {
                arr[--j] = arr[i];
            }
            --i;
            --j;
        }
    }

    public static void duplicateZeros2(int[] arr) {
        int i = 0;
        int zero = 0;
        int n = arr.length - 1;

        while (i <= n) {
            if (arr[i] == 0) {
                zero++;
            }
            if (i + zero >= n) {
                break;
            }
            i++;
        }

        while (i >= 0) {
            arr[n--] = arr[i];
            if (arr[i] == 0 && (i + zero <= n - 1)) {
                arr[n--] = arr[i];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3};
        duplicateZeros2(arr2);
        System.out.println(Arrays.toString(arr2));
    }


}
