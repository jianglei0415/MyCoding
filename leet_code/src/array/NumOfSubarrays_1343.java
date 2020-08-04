package array;

/**
 * @author jianglei
 * @date 2020/6/20 8:33
 * <p>
 * 题号：#1343 大小为 K 且平均值大于等于阈值的子数组数目
 * <p>
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 * <p>
 * 示例 1：
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。
 * 其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 * <p>
 * 示例 2：
 * 输入：arr = [1,1,1,1,1], k = 1, threshold = 0
 * 输出：5
 * <p>
 * 示例 3：
 * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * 输出：6
 * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
 * <p>
 * 示例 4：
 * 输入：arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：arr = [4,4,4,4], k = 4, threshold = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^4
 * 1 <= k <= arr.length
 * 0 <= threshold <= 10^4
 */
public class NumOfSubarrays_1343 {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0, result = 0, sumTarget = k * threshold;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int adder = sum - sumTarget;
        if (adder >= 0) {
            result++;
        }
        int pos = k;
        for (int i = 0; i < arr.length - k; i++) {
            adder = adder + arr[pos] - arr[i];
            if (adder >= 0) {
                result++;
            }
            pos++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 2, 2, 5, 5, 5, 8};
        int k1 = 3;
        int threshold1 = 4;
        int i1 = numOfSubarrays(arr1, k1, threshold1);
        System.out.println(i1);

        int[] arr2 = {1, 1, 1, 1, 1};
        int k2 = 1;
        int threshold2 = 0;
        int i2 = numOfSubarrays(arr2, k2, threshold2);
        System.out.println(i2);

        int[] arr3 = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k3 = 3;
        int threshold3 = 5;
        int i3 = numOfSubarrays(arr3, k3, threshold3);
        System.out.println(i3);

        int[] arr4 = {7, 7, 7, 7, 7, 7, 7};
        int k4 = 7;
        int threshold4 = 7;
        int i4 = numOfSubarrays(arr4, k4, threshold4);
        System.out.println(i4);

        int[] arr5 = {4, 4, 4, 4};
        int k5 = 4;
        int threshold5 = 1;
        int i5 = numOfSubarrays(arr5, k5, threshold5);
        System.out.println(i5);
    }
}
