package list;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/10/20 9:35
 * <p>
 * 题号：#143. 重排链表
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，
 * 而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList_143 {
    public static void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public static void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode l1 = head, l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }

    private static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_temp, l2_temp;
        while (l1 != null && l2 != null) {
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;

            l2.next = l1;
            l2 = l2_temp;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    private static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(node_1);
        System.out.println(node_1);

        ListNode node_2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList2(node_2);
        System.out.println(node_2);
    }
}
