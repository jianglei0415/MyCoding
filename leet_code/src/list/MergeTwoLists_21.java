package list;

import util.ListNode;

/**
 * @author jianglei
 * @date 2020/10/20 19:47
 * <p>
 * 题号：#21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists_21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node_2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node = mergeTwoLists(node_1, node_2);
        System.out.println(node);
    }
}
