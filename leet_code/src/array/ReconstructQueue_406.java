package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/11/16 8:46
 * <p>
 * 题号：#406. 根据身高重建队列
 * <p>
 * 假设有打乱顺序的一群人站成一个队列。
 * 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
 * k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class ReconstructQueue_406 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
        List<int[]> result = new LinkedList<>();
             for (int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = reconstructQueue(people);
        System.out.println(Arrays.deepToString(ints));
    }
}
