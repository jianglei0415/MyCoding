package tree;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jianglei
 * @date 2020/9/24 22:54
 * <p>
 * 题号：#98. 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST_98 {
    /**
     * 方法一：递归
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root, null, null);
    }

    private static boolean dfs(TreeNode root, Integer left, Integer right) {
        if (root == null) {
            return true;
        }
        int value = root.val;
        if (left != null && value <= left) {
            return false;
        }
        if (right != null && value >= right) {
            return false;
        }
        if (!dfs(root.left, left, value)) {
            return false;
        }
        if (!dfs(root.right, value, right)) {
            return false;
        }
        return true;
    }

    /**
     * 方法二：中序遍历
     */
    public static boolean isValidBST2(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= inorder) {
                return false;
            }
            inorder = node.val;
            node = node.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST1 = isValidBST(node_1);
        System.out.println(validBST1);

        TreeNode node_2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean validBST2 = isValidBST2(node_2);
        System.out.println(validBST2);
    }
}
