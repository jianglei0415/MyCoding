package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/10/12 19:53
 * <p>
 * 题号：#530. 二叉搜索树的最小绝对差
 * <p>
 * 给你一棵所有节点为非负值的二叉搜索树，
 * 请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * 示例：
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * 提示：
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class GetMinimumDifference_530 {
    private static int result = Integer.MAX_VALUE;
    private static int pre = -1;

    public static int getMinimumDifference(TreeNode root) {
        dfs(root);
        return result;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            result = Math.min(result, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        int minimumDifference = getMinimumDifference(node);
        System.out.println(minimumDifference);
    }
}
