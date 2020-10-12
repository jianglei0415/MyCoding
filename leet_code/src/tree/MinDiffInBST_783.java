package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/10/12 20:01
 * <p>
 * 题号：#783. 二叉搜索树节点最小距离
 * <p>
 * 给定一个二叉搜索树的根节点 root，
 * 返回树中任意两节点的差的最小值。
 * <p>
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *  
 * 注意：
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 */
public class MinDiffInBST_783 {
    private static int result = Integer.MAX_VALUE, pre = -1;

    public static int minDiffInBST(TreeNode root) {
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
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        int i = minDiffInBST(node);
        System.out.println(i);
    }
}
