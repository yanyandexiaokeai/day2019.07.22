//合并两个排序链表
class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        //一、使用一个新链表
        /*ListNode result = null;
        ListNode last = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                ListNode next = cur1.next;
                if (result == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;

            } else {
                ListNode next = cur2.next;
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        if (cur1 != null) {
            last.next = cur1;
        } else {
            last.next = cur2;
        }
        return result;*/

        //方法二：递归
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}