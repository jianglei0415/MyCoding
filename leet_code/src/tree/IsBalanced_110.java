package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/8/17 8:32
 * <p>
 * 题号：#110. 平衡二叉树
 * <p>
 * 给定一个二叉树，
 * 判断它是否是高度平衡的二叉树。
 * 本题中，
 * 一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class IsBalanced_110 {
    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        if (heightLeft == -1 || heightRight == -1 || Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        } else {
            return Math.max(heightLeft, heightRight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        boolean balanced1 = isBalanced(root1);
        System.out.println(balanced1);

        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        boolean balanced2 = isBalanced(root2);
        System.out.println(balanced2);
    }
}
