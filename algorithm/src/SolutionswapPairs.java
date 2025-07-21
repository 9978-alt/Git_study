public class SolutionswapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1,head);
        ListNode pre = dummyNode,first=head,second = head.next,thrid = second.next;
        while (second!=null) {
            pre.next = second;
            second.next = first;
            first.next = thrid;
            
            pre = first;
            first = thrid;
            second = first ==null? null:first.next;
            thrid = second == null? null:second.next;
        }
        return dummyNode.next;
    }
}
