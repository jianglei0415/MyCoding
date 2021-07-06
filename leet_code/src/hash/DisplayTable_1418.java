package hash;

import java.util.*;

/**
 * @author jianglei
 * @date 2021/7/6 23:15
 * <p>
 * 题号：#1418. 点菜展示表
 * <p>
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说，
 * orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，
 * tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表 。
 * 在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
 * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <p>
 * 示例 1：
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 * <p>
 * 示例 2：
 * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * <p>
 * 示例 3：
 * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 * <p>
 * 提示：
 * 1 <= orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
 * tableNumberi 是 1 到 500 范围内的整数。
 */
public class DisplayTable_1418 {
    public static List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodName = new TreeSet<>();
        Map<Integer, Map<String, Integer>> foods = new HashMap<>();
        for (List<String> order : orders) {
            String name = order.get(2);
            foodName.add(name);
            int tableId = Integer.parseInt(order.get(1));
            Map<String, Integer> map = foods.getOrDefault(tableId, new HashMap<>());
            map.put(name, map.getOrDefault(name, 0) + 1);
            foods.put(tableId, map);
        }

        List<String> foodNames = new ArrayList<>(foodName);

        List<List<String>> result = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("Table");
        for (String s : foodNames) {
            title.add(s);
        }
        result.add(title);

        List<Integer> ids = new ArrayList<>();
        for (int id : foods.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);

        for (int i = 0; i < foods.size(); i++) {
            int id = ids.get(i);
            Map<String, Integer> map = foods.get(id);
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(id));
            for (int j = 0; j < foodNames.size(); j++) {
                row.add(Integer.toString(map.getOrDefault(foodNames.get(j), 0)));
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> orders_1 = new ArrayList<>();
        orders_1.add(Arrays.asList("David", "3", "Ceviche"));
        orders_1.add(Arrays.asList("Corina", "10", "Beef Burrito"));
        orders_1.add(Arrays.asList("David", "3", "Fried Chicken"));
        orders_1.add(Arrays.asList("Carla", "5", "Water"));
        orders_1.add(Arrays.asList("Carla", "5", "Ceviche"));
        orders_1.add(Arrays.asList("Rous", "3", "Ceviche"));
        List<List<String>> lists1 = displayTable(orders_1);
        System.out.println(lists1);

        List<List<String>> orders_2 = new ArrayList<>();
        orders_2.add(Arrays.asList("James", "12", "Fried Chicken"));
        orders_2.add(Arrays.asList("Ratesh", "12", "Fried Chicken"));
        orders_2.add(Arrays.asList("Amadeus", "12", "Fried Chicken"));
        orders_2.add(Arrays.asList("Adam", "1", "Canadian Waffles"));
        orders_2.add(Arrays.asList("Brianna", "1", "Canadian Waffles"));
        List<List<String>> lists2 = displayTable(orders_2);
        System.out.println(lists2);

        List<List<String>> orders_3 = new ArrayList<>();
        orders_3.add(Arrays.asList("Laura", "2", "Bean Burrito"));
        orders_3.add(Arrays.asList("Jhon", "2", "Beef Burrito"));
        orders_3.add(Arrays.asList("Melissa", "2", "Soda"));
        List<List<String>> lists3 = displayTable(orders_3);
        System.out.println(lists3);
    }
}
