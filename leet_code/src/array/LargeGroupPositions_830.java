package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/3/8 17:48
 * <p>
 * 题号：#830. 较大分组的位置
 * <p>
 * 在一个由小写字母构成的字符串 S 中，
 * 包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，
 * 在字符串 S = "abbxxxxzyy" 中，
 * 就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。
 * 找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 * <p>
 * 示例 1:
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * <p>
 * 示例 2:
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * <p>
 * 示例 3:
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * <p>
 * 说明:  1 <= S.length <= 1000
 */
public class LargeGroupPositions_830 {
    private static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int n = S.length();
        for (int j = 0; j < n; j++) {
            if (j == n - 1 || S.charAt(j) != S.charAt(j + 1)) {
                if (j - i + 1 >= 3) {
                    result.add(Arrays.asList(new Integer[]{i, j}));
                }
                i = j + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abbxxxxzzy";
        List<List<Integer>> lists1 = largeGroupPositions(s1);
        System.out.println(lists1);

        String s2 = "abc";
        List<List<Integer>> lists2 = largeGroupPositions(s2);
        System.out.println(lists2);

        String s3 = "abcdddeeeeaabbbcd";
        List<List<Integer>> lists3 = largeGroupPositions(s3);
        System.out.println(lists3);
    }
}
