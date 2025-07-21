public class SolutionHasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head.next,slow = head;
        while (fast != slow) {
            if(fast == null) return false;
            fast = fast.next;
            if(fast == null) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
