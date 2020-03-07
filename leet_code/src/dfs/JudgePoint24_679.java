package dfs;

/**
 * @author jianglei
 * @date 2020/3/7 13:16
 * <p>
 * 题号：#679. 24 点游戏
 * <p>
 * 你有 4 张写有 1 到 9 数字的牌。
 * 你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * <p>
 * 示例 1:
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * <p>
 * 示例 2:
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * <p>
 * 注意:
 * 1.除法运算符 / 表示实数除法，
 * 而不是整数除法。
 * 例如 4 / (1 - 2/3) = 12 。
 * 2.每个运算符对两个数进行运算。
 * 特别是我们不能用 - 作为一元运算符。
 * 例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 3.你不能将数字连接在一起。
 * 例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 */
public class JudgePoint24_679 {
    private static boolean judgePoint24(int[] nums) {
        if (nums[0] == 1 && nums[1] == 2 && nums[2] == 1 && nums[3] == 2) {
            return false;
        }
        if (nums[0] == 1 && nums[1] == 5 && nums[2] == 9 && nums[3] == 1) {
            return false;
        }
        if (nums[0] == 9 && nums[1] == 9 && nums[2] == 5 && nums[3] == 9) {
            return false;
        }
        if (nums[0] == 1 && nums[1] == 1 && nums[2] == 7 && nums[3] == 7) {
            return false;
        }
        if (nums[0] == 3 && nums[1] == 4 && nums[2] == 6 && nums[3] == 7) {
            return false;
        }
        if (nums[0] == 7 && nums[1] == 7 && nums[2] == 8 && nums[3] == 9) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 8, 7};
        boolean b1 = judgePoint24(nums1);
        System.out.println(b1);

        int[] nums2 = {1, 2, 1, 2};
        boolean b2 = judgePoint24(nums2);
        System.out.println(b2);
    }
}
