package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/9/27 23:11
 * <p>
 * 题号：#235. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class LowestCommonAncestor_235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = dfs(root, p);
        List<TreeNode> path_q = dfs(root, q);
        TreeNode result = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                result = path_p.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    private static List<TreeNode> dfs(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while (true) {
            if (p.val < result.val && q.val < result.val) {
                result = result.left;
            } else if (p.val > result.val && q.val > result.val) {
                result = result.right;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));

        TreeNode p_1 = new TreeNode(2);
        TreeNode q_1 = new TreeNode(8);
//        TreeNode node1 = lowestCommonAncestor(node, p_1, q_1);
//        System.out.println(node1);

        TreeNode p_2 = new TreeNode(2);
        TreeNode q_2 = new TreeNode(4);
        TreeNode node2 = lowestCommonAncestor2(node, p_2, q_2);
        System.out.println(node2);
    }
}
