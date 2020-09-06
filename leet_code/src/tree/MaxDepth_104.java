package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/8/17 9:18
 * <p>
 * 题号：#104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树，
 * 找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth_104 {
    public static int maxDepth(TreeNode root) {
        return depth(root);
    }

    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depthLeft = depth(root.left);
        int depthRight = depth(root.right);
        return Math.max(depthLeft, depthRight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i = maxDepth(root);
        System.out.println(i);
    }
}
