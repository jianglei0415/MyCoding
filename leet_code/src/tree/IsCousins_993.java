package tree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianglei
 * @date 2020/9/6 16:18
 * <p>
 * 题号：#993. 二叉树的堂兄弟节点
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */
public class IsCousins_993 {
    private static Map<Integer, Integer> depth = new HashMap<>();
    private static Map<Integer, TreeNode> parent = new HashMap<>();

    public static boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    private static void dfs(TreeNode root, TreeNode par) {
        if (root != null) {
            depth.put(root.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(root.val, par);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }

    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        int x_1 = 4, y_1 = 3;
        boolean cousins1 = isCousins(node_1, x_1, y_1);
        System.out.println(cousins1);

        TreeNode node_2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));
        int x_2 = 5, y_2 = 4;
        boolean cousins2 = isCousins(node_2, x_2, y_2);
        System.out.println(cousins2);

        TreeNode node_3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        int x_3 = 2, y_3 = 3;
        boolean cousins3 = isCousins(node_3, x_3, y_3);
        System.out.println(cousins3);
    }
}
