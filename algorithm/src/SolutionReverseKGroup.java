public class SolutionReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy, end = dummy;

    while (true) {
        // 1. 找到每组的结尾
        for (int i = 0; i < k && end != null; i++) end = end.next;
        if (end == null) break; // 不足k个，结束
        ListNode start = pre.next;
        ListNode next = end.next;
        end.next = null; // 断开
        // 2. 反转
        pre.next = reverse(start);
        start.next = next;
        // 3. 移动指针
        pre = start;
        end = pre;
    }
    return dummy.next;
}

private ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
    
}
