public class SolutionSortList {
    // 从顶向下，采用分治的方法
    // public ListNode sortList(ListNode head) {
    //     return sort(head, null);
    // }

    // 从底向上 归并算法
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        int length = 0;
        ListNode cur = head;
        while (cur!=null) {
            length++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1,head);
        for (int subLength = 1; subLength < length; subLength *= 2) {
            
            ListNode prev = dummy;  // 找到第一个开始归并的节点
            cur = prev.next;
            while (cur!=null) {
                //先找到前subLength个节点添加到一个链表中
                ListNode head1 = cur;
                for (int i = 1; i < subLength; i++) {
                    cur = cur.next;
                }

                // 准备第二个链表
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if(cur!=null){
                    next = cur.next;// 记录剩余节点
                    cur.next = null;
                }
                
                ListNode sorted = merge(head1, head2);
                prev.next = sorted;
                prev = sorted;
                cur = next;
            }
        }
        return dummy.next;
    }


    // private ListNode sort(ListNode head,ListNode tail){
    //     if(head==null) return null;
        
    //     ListNode fast=head,slow = head; // 找到链表的中点
    //     while (fast!=tail) {
    //         fast = fast.next;
    //         slow = slow.next;
    //         fast = fast == tail? fast:fast.next;
    //     }

    //     ListNode left = sort(head, slow);
    //     ListNode right = sort(slow, tail);

    //     return merge(left,right);
    // }

    private ListNode merge(ListNode list1,ListNode list2){
        ListNode dummyNode = new ListNode(-1),tail = dummyNode;
        ListNode cur1 = list1,cur2 = list2;
        while (cur1 != null && cur2!=null) {
            if(cur1.val < cur2.val){
                tail.next = cur1;
                cur1 = cur1.next;
                tail = tail.next;
            }else{
                tail.next = cur2;
                cur2 = cur2.next;
                tail = tail.next;
            }
        }
        if(cur1!=null) tail.next = cur1;
        if(cur2!=null) tail.next = cur2;
        return dummyNode.next;
    }
}
