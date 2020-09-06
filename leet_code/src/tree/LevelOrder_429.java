package tree;

import util.Node;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/9/6 15:58
 * <p>
 * 题号：#429. N叉树的层序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树
 * 返回其层序遍历:
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 */
public class LevelOrder_429 {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                List<Node> neighbors = node.neighbors;
                if (neighbors != null) {
                    queue.addAll(neighbors);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Node> list1 = new ArrayList<>();
        list1.add(new Node(5));
        list1.add(new Node(6));

        ArrayList<Node> list2 = new ArrayList<>();
        list2.add(new Node(3, list1));
        list2.add(new Node(2));
        list2.add(new Node(4));

        Node node = new Node(1, list2);
        List<List<Integer>> lists = levelOrder(node);
        System.out.println(lists);
    }
}
