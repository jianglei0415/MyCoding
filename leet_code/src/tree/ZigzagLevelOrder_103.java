package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jianglei
 * @date 2020/9/6 15:32
 * <p>
 * 题号：#103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class ZigzagLevelOrder_103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            flag = !flag;
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (!flag) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }

                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> lists = zigzagLevelOrder(node);
        System.out.println(lists);
    }
}
