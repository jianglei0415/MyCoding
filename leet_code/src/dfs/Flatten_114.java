package dfs;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/10/19 19:02
 * <p>
 * 题号：#114. 二叉树展开为链表
 * <p>
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * 例如，给定二叉树
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class Flatten_114 {
    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(node);
        System.out.println(node);
    }
}
