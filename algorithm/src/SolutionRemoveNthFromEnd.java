
public class SolutionRemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummNode = new ListNode(0,head);
        ListNode fast = dummNode,slow=dummNode;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null && fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.next == null) slow.next = null;
        else slow.next = slow.next.next;
        return head;
    }
}