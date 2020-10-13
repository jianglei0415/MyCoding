package list;

import util.ListNode;

/**
 * @author jianglei
 * @date 2020/10/13 19:03
 * <p>
 * 题号：#24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class SwapPairs_24 {
    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode temp = node;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node1 = swapPairs2(node_1);
        System.out.println(node1);

        ListNode node_2 = new ListNode();
        ListNode node2 = swapPairs(node_2);
        System.out.println(node2);

        ListNode node_3 = new ListNode(1);
        ListNode node3 = swapPairs(node_3);
        System.out.println(node3);
    }
}
