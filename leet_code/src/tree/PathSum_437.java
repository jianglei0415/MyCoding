package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/26 21:30
 * <p>
 * 题号：#437. 路径总和 III
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * 返回 3。和等于 8 的路径有:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class PathSum_437 {
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = dfs(root, sum);
        int a = pathSum(root.left, sum);
        int b = pathSum(root.right, sum);
        return result + a + b;
    }

    public static int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int result = (sum == 0) ? 1 : 0;
        return result + dfs(root.left, sum) + dfs(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        int sum = 8;
        int i = pathSum(node, sum);
        System.out.println(i);
    }
}
