package offer;

/**
 * @author jianglei
 * @date 2020/3/5 16:52
 * <p>
 * 题号：#面试题24. 反转链表
 * <p>
 * 定义一个函数，
 * 输入一个链表的头节点，
 * 反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 注意：
 * 本题与主站 206 题相同：
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList_24 {
    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = reverseList(listNode);
        System.out.println(listNode1);
    }
}
