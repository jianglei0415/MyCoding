package array;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/2/21 22:19
 * <p>
 * 题号：#381 O(1) 时间插入、删除和获取随机元素 - 允许重复
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下， 
 * 执行以下操作的数据结构。
 * 注意: 允许出现重复元素。
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。
 * 每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * <p>
 * 示例:
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 */
public class RandomizedCollection_381 {
    private List<Integer> lst;
    private Random random = new Random();
    private Map<Integer, Set<Integer>> idx;

    public RandomizedCollection_381() {
        lst = new ArrayList<>();
        idx = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!idx.containsKey(val)) {
            idx.put(val, new LinkedHashSet<>());
        }
        idx.get(val).add(lst.size());
        lst.add(val);
        return idx.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val) || idx.get(val).size() == 0) {
            return false;
        }
        int remove_idx = idx.get(val).iterator().next();
        idx.get(val).remove(remove_idx);
        int last = lst.get(lst.size() - 1);
        lst.set(remove_idx, last);
        idx.get(last).add(remove_idx);
        idx.get(last).remove(lst.size() - 1);
        lst.remove(lst.size() - 1);
        return true;
    }

    public int getRandom() {
        return lst.get(random.nextInt(lst.size()));
    }

    public static void main(String[] args) {
        int val = 10;
        RandomizedCollection_381 obj = new RandomizedCollection_381();
        boolean param_1 = obj.insert(val);
        System.out.println(param_1);
        boolean param_2 = obj.remove(val);
        System.out.println(param_2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }
}
