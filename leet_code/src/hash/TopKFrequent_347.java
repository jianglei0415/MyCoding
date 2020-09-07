package hash;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/9/7 10:01
 * <p>
 * 题号：#347. 前 K 个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TopKFrequent_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

//        Comparator<Map.Entry<Integer, Integer>> valueComparator = (o1, o2) -> o2.getValue() - o1.getValue();
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list, valueComparator);

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (int i : map.keySet()) {
            queue.add(i);
        }
        int i = 0;
        while (i < k) {
            result[i++] = queue.poll();
        }


//        if (k > map.size()) {
//            return null;
//        }

//        for (int i = 0; i < k; i++) {
//            Map.Entry<Integer, Integer> entry = list.get(i);
//            result[i] = entry.getKey();
//        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums_1 = {1, 1, 1, 2, 2, 3};
        int k_1 = 2;
        int[] ints1 = topKFrequent(nums_1, k_1);
        System.out.println(Arrays.toString(ints1));

        int[] nums_2 = {1};
        int k_2 = 1;
        int[] ints2 = topKFrequent(nums_2, k_2);
        System.out.println(Arrays.toString(ints2));
    }
}
