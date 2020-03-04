package offer;

/**
 * @author jianglei
 * @date 2020/2/27 23:27
 */
public class ListNode {
    private int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
