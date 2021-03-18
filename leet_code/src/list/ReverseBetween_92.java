package list;

import util.ListNode;

/**
 * @author jianglei
 * @date 2021/3/18 22:24
 * <p>
 * 题号：#92. 反转链表 II
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class ReverseBetween_92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node1 = reverseBetween(node, 2, 4);
        System.out.println(node1);

        ListNode node2 = new ListNode(5);
        ListNode node3 = reverseBetween(node2, 1, 1);
        System.out.println(node3);
    }
}
