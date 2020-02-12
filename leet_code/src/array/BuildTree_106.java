package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/2/9 23:44
 * <p>
 * 题号：#106 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class BuildTree_106 {
    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode help(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd) {
        if (inStart > inEnd || posStart > posEnd) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[posEnd]);
        int index = 0;
        while (inorder[inStart + index] != postorder[posEnd]) {
            index++;
        }
        head.left = help(inorder, inStart, inStart + index - 1, postorder, posStart, posStart + index - 1);
        head.right = help(inorder, inStart + index + 1, inEnd, postorder, posStart + index, posEnd - 1);
        return head;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
