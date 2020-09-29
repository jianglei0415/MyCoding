package tree;

import util.Node;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/9/29 18:59
 * <p>
 * 题号：#590. N叉树的后序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Postorder_590 {
    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private static void dfs(Node root, List<Integer> result) {
        if (root != null) {
            List<Node> neighbors = root.neighbors;
            for (int i = 0; i < neighbors.size(); i++) {
                dfs(neighbors.get(i), result);
            }
            result.add(root.val);
        }
    }

    /**
     * 方法二：迭代
     */
    public static List<Integer> postorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int n = stack.size();
            for (int i = 0; i < n; i++) {
                Node poll = stack.poll();
                result.add(0, poll.val);
                List<Node> temp = poll.neighbors;
                for (Node node : temp) {
                    stack.push(node);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Node> children_1 = new ArrayList<>();
        children_1.add(new Node(5));
        children_1.add(new Node(6));

        List<Node> children_2 = new ArrayList<>();
        children_2.add(new Node(3, children_1));
        children_2.add(new Node(2));
        children_2.add(new Node(4));

        Node node = new Node(1, children_2);
        List<Integer> postorder = postorder(node);
        System.out.println(postorder);

        List<Integer> postorder2 = postorder2(node);
        System.out.println(postorder2);
    }
}
