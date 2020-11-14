package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/11/14 10:44
 * <p>
 * 题号：#1122. 数组的相对排序
 * <p>
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，
 * 使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 提示：
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray_1122 {
    /**
     * 方法一：使用自带sort排序
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] array = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            array[i] = arr1[i];
        }

        Arrays.sort(array, (o1, o2) -> {
            if (map.containsKey(o1) && map.containsKey(o2)) {
                return map.get(o1) - map.get(o2);
            }

            if (map.containsKey(o1)) {
                return -1;
            }

            if (map.containsKey(o2)) {
                return 1;
            }

            return o1 - o2;
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = array[i];
        }
        return arr1;
    }

    /**
     * 方法二
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for (int i : arr1) {
            int n = map[i];
            if (n == 0) {
                map[i] = 1;
            } else {
                map[i] = n + 1;
            }
        }

        int k = 0;
        for (int i : arr2) {
            int n = map[i];
            while (n > 0) {
                arr1[k] = i;
                n--;
                k++;
            }
            map[i] = 0;
        }

        for (int i = 0; i < map.length; i++) {
            int value = map[i];
            while (value > 0) {
                arr1[k] = i;
                k++;
                value--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] ints = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));

        int[] arr1_copy = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2_copy = {2, 1, 4, 3, 9, 6};
        int[] ints_copy = relativeSortArray2(arr1_copy, arr2_copy);
        System.out.println(Arrays.toString(ints_copy));
    }
}
