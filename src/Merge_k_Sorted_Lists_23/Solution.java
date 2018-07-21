package Merge_k_Sorted_Lists_23;

/**
 * Created by qy_lu on 2018/7/21.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode node = divideAndConque(lists, 0, len - 1);
        return node;
    }

    private ListNode divideAndConque(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (end - start == 1) {
            return sortTwoList(lists[start], lists[end]);
        }
        if (end > start) {
            int mid = start + (end - start) / 2;
            ListNode list1 = divideAndConque(lists, start, mid);
            ListNode list2 = divideAndConque(lists, mid + 1, end);
            return sortTwoList(list1, list2);
        }
        return null;
    }

    private ListNode sortTwoList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            int val;
            if (list1.val < list2.val) {
                val = list1.val;
                list1 = list1.next;
            } else {
                val = list2.val;
                list2 = list2.next;
            }
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        while (list1 != null) {
            ListNode node = new ListNode(list1.val);
            cur.next = node;
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode node = new ListNode(list2.val);
            cur.next = node;
            cur = cur.next;
            list2 = list2.next;
        }
        return head.next;
    }
}
