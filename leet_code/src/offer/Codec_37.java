package offer;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianglei
 * @date 2021/6/30 20:43
 * <p>
 * 题号：#剑指 Offer 37. 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec_37 {
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDfs(root, sb);
        return sb.toString();
    }

    private static void serializeDfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serializeDfs(root.left, sb);
        serializeDfs(root.right, sb);
    }

    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return deserializeDfs(list);
    }

    private static TreeNode deserializeDfs(List<String> list) {
        String s = list.get(0);
        if ("null".equals(s)) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(s));
        list.remove(0);
        node.left = deserializeDfs(list);
        node.right = deserializeDfs(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serialize = serialize(node);
        System.out.println(serialize);

        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);
    }
}
