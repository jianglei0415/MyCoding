package dfs;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jianglei
 * @date 2021/6/30 20:44
 */
public class Codec_297 {
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
        TreeNode node_1 = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serialize = serialize(node_1);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);

        TreeNode node_2 = new TreeNode();
        String serialize1 = serialize(node_2);
        System.out.println(serialize1);
        TreeNode deserialize1 = deserialize(serialize1);
        System.out.println(deserialize1);

        TreeNode node_3 = new TreeNode(1);
        String serialize2 = serialize(node_3);
        System.out.println(serialize2);
        TreeNode deserialize2 = deserialize(serialize2);
        System.out.println(deserialize2);

        TreeNode node_4 = new TreeNode(1, new TreeNode(2), null);
        String serialize3 = serialize(node_4);
        System.out.println(serialize3);
        TreeNode deserialize3 = deserialize(serialize3);
        System.out.println(deserialize3);
    }
}
