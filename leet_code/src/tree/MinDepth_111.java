package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/8/17 9:27
 * <p>
 * 题号：#111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class MinDepth_111 {
    public static int minDepth(TreeNode root) {
        return min(root);
    }

    private static int min(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = min(root.left);
        int right = min(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i1 = minDepth(root1);
        System.out.println(i1);

        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        int i2 = minDepth(root2);
        System.out.println(i2);
    }
}
