public class SolutionmergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        ListNode cur1 = list1,cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if(cur1.val < cur2.val){
                tail.next = cur1;
                tail = cur1;
                cur1 = cur1.next;
            }else {
                tail.next = cur2;
                tail = cur2;
                cur2 = cur2.next;
            }
        }

        if(cur1!=null) tail.next = cur1;
        if(cur2!=null) tail.next =cur2;
        return dummyNode.next;
    }
}
