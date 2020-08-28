package offer;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/2/27 23:25
 * <p>
 * 题号：面试题07. 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 限制：=
 * 0 <= 节点个数 <= 5000
 * <p>
 * 注意：
 * 本题与主站 105 题重复：
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree_07 {
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, 0, inorder.length, map);
    }

    private static TreeNode build(int[] preorder, int p_start, int p_end, int i_start, int i_end, Map<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;
        root.left = build(preorder, p_start + 1, p_start + 1 + leftNum, i_start, i_root_index, map);
        root.right = build(preorder, p_start + leftNum + 1, p_end, i_root_index + 1, i_end, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
