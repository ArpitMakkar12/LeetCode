/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow;
        ListNode temp = middle.next;

        middle.next = reverse(temp);

        ListNode head1 = head;
        ListNode head2 = middle.next;

        while(head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}