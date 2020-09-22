package tree;

import util.TreeNode;

/**
 * @author jianglei
 * @date 2020/9/22 19:04
 * <p>
 * 题号：#968. 监控二叉树
 * <p>
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * 示例 1：
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * <p>
 * 示例 2：
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 */
public class MinCameraCover_968 {
    /**
     * 表示子节点没有相机，当前节点也没相机
     */
    private static final int NO_CAMERA = 0;

    /**
     * 表示当前节点有一个相机
     */
    private static final int HAS_CAMERA = 1;

    /**
     * 表示当前节点子节点有相机，自己不需要相机
     */
    private static final int NO_NEEDED = 2;

    /**
     * 表示需要多少个相机
     */
    private static int result = 0;

    public static int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //表示根节点的子节点都没有相机，所以需要添加一个
        if (dfs(root) == NO_CAMERA) {
            result++;
        }
        return result;
    }

    private static int dfs(TreeNode root) {
        //如果节点为null，表示不需要相机
        if (root == null) {
            return NO_NEEDED;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        //如果左子树无相机或者右子树无相机表示左右子节点中既没相机也没有相机覆盖到它，所以添加一个给当前根节点
        if (left == NO_CAMERA || right == NO_CAMERA) {
            result++;
            return HAS_CAMERA;
        }

        //如果左子树或右子树存在相机，表示当前根节点不需要相机，如果左右子节点都没有表示没有相机
        return left == HAS_CAMERA || right == HAS_CAMERA ? NO_NEEDED : NO_CAMERA;
    }

    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(0, new TreeNode(0, new TreeNode(0), new TreeNode(0)), null);
        int i1 = minCameraCover(node_1);
        System.out.println(i1);

        TreeNode node_2 = new TreeNode(0, new TreeNode(0, new TreeNode(0, new TreeNode(0, null, new TreeNode(0)), null), null), null);
        int i2 = minCameraCover(node_2);
        System.out.println(i2);
    }
}
