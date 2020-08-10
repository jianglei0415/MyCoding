package tree;

import array.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/8/8 14:36
 * <p>
 * 题号：#99 恢复二叉搜索树
 * <p>
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * 输出: [3,1,null,null,2]
 *    3
 *   /
 *  1
 *   \
 *    2
 * <p>
 * 示例 2:
 * 输入: [3,1,4,null,null,2]
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * 输出: [2,1,4,null,null,3]
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * <p>
 * 进阶:
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class RecoverTree_99 {
    public static void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private static void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private static int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    private static void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        recoverTree(treeNode1);
        System.out.println(treeNode1);

        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        recoverTree(treeNode2);
        System.out.println(treeNode2);
    }
}
