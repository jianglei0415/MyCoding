package array;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/2/21 21:34
 * <p>
 * 题号：#380 常数时间插入、删除和获取随机元素
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下，
 * 执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * <p>
 * 示例 :
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 */
public class RandomizedSet_380 {
    private Map<Integer, Integer> dict;
    private List<Integer> list;
    Random random = new Random();

    public RandomizedSet_380() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(list.size() - 1);
        int index = dict.get(val);
        list.set(index, lastElement);
        dict.put(lastElement, index);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        int val = 10;
        RandomizedSet_380 obj = new RandomizedSet_380();
        boolean param_1 = obj.insert(val);
        System.out.println(param_1);
        boolean param_2 = obj.remove(val);
        System.out.println(param_2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }
}
