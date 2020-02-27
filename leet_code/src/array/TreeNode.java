package array;

/**
 * @author: jianglei
 * @date: 2020/2/9 23:45
 */
public class TreeNode {
    private int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
