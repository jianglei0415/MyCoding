package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jianglei
 * @date 2020/9/6 15:11
 * <p>
 * 题号：#637. 二叉树的层平均值
 * <p>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * 示例 1：
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
public class AverageOfLevels_637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<Double> list = averageOfLevels(node);
        System.out.println(list);
    }
}
