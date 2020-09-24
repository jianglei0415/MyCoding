package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/24 22:16
 * <p>
 * 题号：#501. 二叉搜索树中的众数
 * <p>
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 例如：
 * 给定 BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class FindMode_501 {
    private static List<Integer> list = new ArrayList<>();
    private static int current = 0;
    private static int count = 0;
    private static int maxCount = 0;

    public static int[] findMode(TreeNode root) {
        inOrder(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        int nodeVal = root.val;
        if (nodeVal == current) {
            count++;
        } else {
            current = nodeVal;
            count = 1;
        }

        if (count == maxCount) {
            list.add(nodeVal);
        } else if (count > maxCount) {
            list.clear();
            list.add(nodeVal);
            maxCount = count;
        }

        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        int[] mode = findMode(node);
        System.out.println(Arrays.toString(mode));
    }
}
