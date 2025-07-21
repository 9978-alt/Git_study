
public class SolutionReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = head,next=null;
        while (cur!= null) {
            next = cur.next;
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            cur = next;
            
        }
        return dummyNode.next;

    }


}
