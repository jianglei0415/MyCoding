package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jianglei
 * @date 2020/9/28 20:27
 * <p>
 * 题号：#199. 二叉树的右视图
 * <p>
 * 给定一棵二叉树，
 * 想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，
 * 返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class RightSideView_199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode poll = queue.poll();
                if (i == n) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        List<Integer> list = rightSideView(node);
        System.out.println(list);
    }
}
