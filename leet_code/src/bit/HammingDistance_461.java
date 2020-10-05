package bit;

/**
 * @author jianglei
 * @date 2020/10/5 15:26
 * <p>
 * 题号：#461. 汉明距离
 * <p>
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance_461 {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            x >>= 1;
            y >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        int i = hammingDistance(x, y);
        System.out.println(i);
    }
}
