package Remove_Nth_Node_From_End_of_List_19;

/**
 * 保持两点之间距离为n+1，同时移动两点
 * Created by qy_lu on 2018/1/14.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}