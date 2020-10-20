package list;

import util.ListNode;

/**
 * @author jianglei
 * @date 2020/10/20 18:44
 * <p>
 * 题号：#876. 链表的中间结点
 * <p>
 * 给定一个带有头结点 head 的非空单链表，
 * 返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 提示：
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class MiddleNode_876 {
    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        ListNode result = head;
        for (int i = 0; i < count / 2; i++) {
            result = result.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node1 = middleNode(node_1);
        System.out.println(node1);

        ListNode node_2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode node2 = middleNode(node_2);
        System.out.println(node2);
    }
}
