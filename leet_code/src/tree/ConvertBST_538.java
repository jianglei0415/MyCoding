package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/9/21 20:07
 * <p>
 * 题号：#538. 把二叉搜索树转换为累加树
 * <p>
 * 给定一个二叉搜索树（Binary Search Tree），
 * 把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */
public class ConvertBST_538 {
    private static int result = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            result += root.val;
            root.val = result;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(2), new TreeNode(13));
        TreeNode node1 = convertBST(node);
        System.out.println(node1);
    }
}
