package math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jianglei
 * @date 2020/8/4 18:43
 * <p>
 * 题号：#949 给定数字能组成的最大时间
 * <p>
 * 给定一个由 4 位数字组成的数组，
 * 返回可以设置的符合 24 小时制的最大时间。
 * 最小的 24 小时制时间是 00:00，
 * 而最大的是 23:59。
 * 从 00:00 （午夜）开始算起，过得越久，时间越大。
 * 以长度为 5 的字符串返回答案。
 * 如果不能确定有效时间，则返回空字符串。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * <p>
 * 示例 2：
 * 输入：[5,5,5,5]
 * 输出：""
 * <p>
 * 提示：
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class LargestTimeFromDigits_949 {
    public static String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        int[] temp1 = new int[4];
        for (int i = 23; i >= 0; i--) {
            for (int j = 59; j >= 0; j--) {
                temp1[0] = i / 10;
                temp1[1] = i % 10;
                temp1[2] = j / 10;
                temp1[3] = j % 10;

                int[] temp2 = new int[4];
                temp2[0] = temp1[0];
                temp2[1] = temp1[1];
                temp2[2] = temp1[2];
                temp2[3] = temp1[3];

                Arrays.sort(temp1);
                if (check(A, temp1)) {
                    return temp2[0] + "" + temp2[1] + ":" + temp2[2] + "" + temp2[3];
                }
            }
        }
        return "";
    }

    private static boolean check(int[] a, int[] temp1) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != temp1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A1 = new int[]{1, 2, 3, 4};
        String s1 = largestTimeFromDigits(A1);
        System.out.println(s1);

        int[] A2 = new int[]{5, 5, 5, 5};
        String s2 = largestTimeFromDigits(A2);
        System.out.println(s2);

        int[] A3 = new int[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            A3[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(A3));
        String s3 = largestTimeFromDigits(A3);
        System.out.println(s3);
    }
}
