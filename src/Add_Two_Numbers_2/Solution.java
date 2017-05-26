package Add_Two_Numbers_2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = null, p = null, l = null;
        int fac = 0;
        do {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + fac;
            int val = sum % 10;
            fac = sum / 10;

            if (l != null) {
                p = l;
            }
            l = new ListNode(val);
            if (h == null) {
                h = l;
            }
            if (p != null) {
                p.next = l;
            }

        } while ((l1 != null || l2 != null) || fac > 0);

        return h;
    }
}
