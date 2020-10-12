package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/10/12 20:10
 * <p>
 * 题号：#671. 二叉树中第二小的节点
 * <p>
 * 给定一个非空特殊的二叉树，
 * 每个节点都是正数，
 * 并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，
 * 那么该节点的值等于两个子节点中较小的一个。
 * 给出这样的一个二叉树，
 * 你需要输出所有节点中的第二小的值。
 * 如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * <p>
 * 示例 2:
 * 输入:
 * 2
 * / \
 * 2   2
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class FindSecondMinimumValue_671 {
    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }

        if (root.val > min) {
            return root.val;
        }

        int left = dfs(root.left, min);
        int right = dfs(root.right, min);

        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        return Math.min(left, right);
    }

    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        int secondMinimumValue1 = findSecondMinimumValue(node_1);
        System.out.println(secondMinimumValue1);

        TreeNode node_2 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        int secondMinimumValue2 = findSecondMinimumValue(node_2);
        System.out.println(secondMinimumValue2);
    }
}
