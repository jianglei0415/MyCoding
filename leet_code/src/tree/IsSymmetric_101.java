package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/10/27 19:57
 * <p>
 * 题号：#101. 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *    1
 *   / \
 *  2   2
 *  \   \
 * 3    3
 *  
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class IsSymmetric_101 {
    public static boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean symmetric = isSymmetric(node);
        System.out.println(symmetric);
    }
}
