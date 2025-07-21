public class SolutionDetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next == null) return null;
        ListNode fast = head.next,slow = head;
        while (fast != slow) {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast;
    }
}
