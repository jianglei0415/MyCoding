package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/10/28 17:04
 * <p>
 * 题号：#1207. 独一无二的出现次数
 * <p>
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueOccurrences_1207 {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(map.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr_1 = {1, 2, 2, 1, 1, 3};
        boolean b1 = uniqueOccurrences(arr_1);
        System.out.println(b1);

        int[] arr_2 = {1, 2};
        boolean b2 = uniqueOccurrences(arr_2);
        System.out.println(b2);

        int[] arr_3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        boolean b3 = uniqueOccurrences(arr_3);
        System.out.println(b3);
    }
}
