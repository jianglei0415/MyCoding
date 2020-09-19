package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/9/19 11:33
 * <p>
 * 题号：#404. 左叶子之和
 * <p>
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class SumOfLeftLeaves_404 {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i = sumOfLeftLeaves(node);
        System.out.println(i);
    }
}
