package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/9/30 17:13
 * <p>
 * 题号：#700. 二叉搜索树中的搜索
 * <p>
 * 给定二叉搜索树（BST）的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。
 * 如果节点不存在，则返回 NULL。
 * <p>
 * 例如，
 * 给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 和值: 2
 * 你应该返回如下子树:
 *      2
 *     / \
 *    1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 */
public class SearchBST_700 {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                if (curr.left == null) {
                    return null;
                } else {
                    curr = curr.left;
                }
            } else if (val > curr.val) {
                if (curr.right == null) {
                    return null;
                } else {
                    curr = curr.right;
                }
            } else {
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        int val = 2;
        TreeNode node = searchBST(root, val);
        System.out.println(node);
    }
}
