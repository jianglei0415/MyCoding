package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/26 20:09
 * <p>
 * 题号：#113. 路径总和 II
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSum_113 {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root, sum, result, temp);
        return result;
    }

    private static void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp) {
        if (root == null) {
            return;
        }

        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        dfs(root.left, sum - root.val, result, temp);
        dfs(root.right, sum - root.val, result, temp);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        int sum = 22;
        List<List<Integer>> lists = pathSum(node, sum);
        System.out.println(lists);
    }
}
