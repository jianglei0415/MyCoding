package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/10/3 10:19
 * <p>
 * 题号：#560. 和为K的子数组
 * <p>
 * 给定一个整数数组和一个整数 k，
 * 你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * <p>
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubarraySum_560 {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }
}
