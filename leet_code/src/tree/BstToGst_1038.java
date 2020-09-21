package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/9/21 20:21
 * <p>
 * 题号：#1038. 从二叉搜索树到更大和树
 * <p>
 * 给出二叉 搜索 树的根节点，
 * 该二叉树的节点值各不相同，
 * 修改二叉树，
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class BstToGst_1038 {
    private static int result = 0;

    public static TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            result += root.val;
            root.val = result;
            bstToGst(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        TreeNode node1 = bstToGst(node);
        System.out.println(node1);
    }
}
