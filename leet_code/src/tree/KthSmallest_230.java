package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/10/12 20:23
 * <p>
 * 题号：#230. 二叉搜索树中第K小的元素
 * <p>
 * 给定一个二叉搜索树，
 * 编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * <p>
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，
 * 你将如何优化 kthSmallest 函数？
 */
public class KthSmallest_230 {
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = dfs(root, new ArrayList<>());
        return list.get(k - 1);
    }

    private static List<Integer> dfs(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int k_1 = 1;
        int i1 = kthSmallest(node_1, k_1);
        System.out.println(i1);

        TreeNode node_2 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        int k_2 = 3;
        int i2 = kthSmallest(node_2, k_2);
        System.out.println(i2);
    }
}
