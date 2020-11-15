package offer;

/**
 * @author jianglei
 * @date 2020/11/14 22:08
 * <p>
 * 题号：#剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 */
public class FindRepeatNumber_03 {
    public static int findRepeatNumber(int[] nums) {
        int[] temp = new int[100001];
        for (int num : nums) {
            int n = temp[num];
            if (n == 0) {
                temp[num] = 1;
            } else {
                temp[num] = n + 1;
                if (n > 1) {
                    return num;
                }
            }
        }


        for (int i = 0; i < temp.length; i++) {
            int n = temp[i];
            if (n > 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }
}
