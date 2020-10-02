package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/10/2 11:50
 * <p>
 * 题号：#771. 宝石与石头
 * <p>
 *  给定字符串J 代表石头中宝石的类型，
 * 和字符串 S代表你拥有的石头。
 *  S 中每个字符代表了一种你拥有的石头的类型，
 * 你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，
 * J 和 S中的所有字符都是字母。
 * 字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * <p>
 * 注意:
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 */
public class NumJewelsInStones_771 {
    public static int numJewelsInStones(String J, String S) {
        int result = 0;

        Set<Character> jSet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jSet.add(J.charAt(i));
        }

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (jSet.contains(chars[i])) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String J_1 = "aA";
        String S_1 = "aAAbbbb";
        int i1 = numJewelsInStones(J_1, S_1);
        System.out.println(i1);

        String J_2 = "z";
        String S_2 = "ZZ";
        int i2 = numJewelsInStones(J_2, S_2);
        System.out.println(i2);
    }
}
