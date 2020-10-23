package list;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianglei
 * @date 2020/10/23 8:33
 * <p>
 * 题号：#234. 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome_234 {
    public static boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int start = 0, end = values.size() - 1;
        while (start < end) {
            if (!values.get(start).equals(values.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1, new ListNode(2));
        boolean palindrome1 = isPalindrome(node_1);
        System.out.println(palindrome1);

        ListNode node_2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        boolean palindrome2 = isPalindrome(node_2);
        System.out.println(palindrome2);
    }
}
