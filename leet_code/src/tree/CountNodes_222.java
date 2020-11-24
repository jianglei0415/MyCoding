package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/11/24 19:04
 * <p>
 * 题号：#222. 完全二叉树的节点个数
 * <p>
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：
 * 在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * 输出: 6
 */
public class CountNodes_222 {
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        int i = countNodes(node);
        System.out.println(i);
    }
}
