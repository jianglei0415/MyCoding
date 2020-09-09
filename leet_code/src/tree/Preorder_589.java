package tree;

import util.Node;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/9/8 23:30
 * <p>
 * 题号：#589. N叉树的前序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class Preorder_589 {
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            Collections.reverse(node.neighbors);
            for (Node item : node.neighbors) {
                stack.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Node> list1 = new ArrayList<>();
        list1.add(new Node(5));
        list1.add(new Node(6));

        ArrayList<Node> list2 = new ArrayList<>();
        list2.add(new Node(3,list1));
        list2.add(new Node(2));
        list2.add(new Node(4));

        Node node = new Node(1, list2);
        List<Integer> preorder = preorder(node);
        System.out.println(preorder);
    }
}
