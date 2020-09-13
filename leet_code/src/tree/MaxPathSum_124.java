package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/9/13 10:50
 * <p>
 * 题号：#124. 二叉树中的最大路径和
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3]
 *   1
 *  / \
 * 2   3
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：[-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：42
 */
public class MaxPathSum_124 {
    private static int result = Integer.MIN_VALUE;


    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int maxPathSum = root.val + left + right;
        result = Math.max(result, maxPathSum);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int i1 = maxPathSum(node_1);
        System.out.println(i1);

        TreeNode node_2 = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i2 = maxPathSum(node_2);
        System.out.println(i2);
    }
}
