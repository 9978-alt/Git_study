import java.util.*;

public class SolutionMergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = lists == null ? new ArrayList<>() : Arrays.asList(lists);
        if(list.size() == 0) return null;
        while (list.size() > 1) {
            ListNode head1 = list.remove(0);
            ListNode head2 = list.remove(1);
            ListNode head = mergeTwoList(head1,head2);
            list.add(head);
        }
        return list.get(0);
    }
    private ListNode mergeTwoList(ListNode head1 , ListNode head2){
        ListNode cur1 = head1,cur2 = head2;
        ListNode dummyNode = new ListNode(-1),tail = dummyNode;
        while (cur1!=null && cur2!=null) {
            
            if(cur1.val < cur2.val){
                tail.next = cur1;
                cur1 = cur1.next;
                tail = tail.next;
                tail.next = null;
            }else {
                tail.next = cur2;
                cur2 = cur2.next;
                tail=tail.next;
                tail.next = null;
            }
        }
        if(cur1 != null){
            tail.next = cur1;
        }
        if(cur2 != null){
            tail.next = cur2;
        }
        return dummyNode.next;
    }
}
