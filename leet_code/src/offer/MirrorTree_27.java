package offer;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2021/6/15 22:26
 * <p>
 * 题号：#剑指 Offer 27. 二叉树的镜像
 * <p>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 1000
 * <p>
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class MirrorTree_27 {
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.val);
        TreeNode node1 = mirrorTree(root.left);
        TreeNode node2 = mirrorTree(root.right);
        node.left = node2;
        node.right = node1;
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode node = mirrorTree(root);
        System.out.println(node);
    }
}
