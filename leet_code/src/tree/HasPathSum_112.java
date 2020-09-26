package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/26 21:15
 * <p>
 * 题号：#112. 路径总和
 * <p>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum_112 {
    public static boolean hasPathSum(TreeNode root, int sum) {
        //方法一
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        //方法一
//        List<Integer> temp = new ArrayList<>();
//        return dfs(root, sum, temp);
    }

    private static boolean dfs(TreeNode root, int sum, List<Integer> temp) {
        if (root == null) {
            return false;
        }

        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return true;
            }
            temp.remove(temp.size() - 1);
        }
        return dfs(root.left, sum - root.val, temp) || dfs(root.right, sum - root.val, temp);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        int sum = 22;
        boolean b = hasPathSum(node, sum);
        System.out.println(b);
    }
}
