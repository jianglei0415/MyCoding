package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jianglei
 * @date 2020/9/6 13:59
 * <p>
 * 题号：#107. 二叉树的层次遍历 II
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottom_107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }

                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(0, level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> lists = levelOrderBottom(node);
        System.out.println(lists);
    }
}
