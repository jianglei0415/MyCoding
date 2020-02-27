package offer;

/**
 * @author jianglei
 * @date 2020/2/27 22:58
 * <p>
 * 题号：面试题22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，
 * 输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，
 * 本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，
 * 从头节点开始，
 * 它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class GetKthFromEnd_22 {
    private static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode listNode = head;
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        length = length - k;
        while (length > 0) {
            length--;
            head = head.next;
        }
        return head;
    }

    /**
     * 快慢指针，快指针先走k步，然后快慢指针一起走，等到快指针走到底慢指针就是倒数第k
     */
    private static ListNode getKthFromEnd1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode end = head;
        for (int i = 0; i < k && first != null; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            end = end.next;
        }
        return end;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next = new ListNode(5);
        int k = 2;
        ListNode kthFromEnd = getKthFromEnd(listNode, k);
        System.out.println(kthFromEnd);
    }
}
