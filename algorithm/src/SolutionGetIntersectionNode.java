class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x,ListNode nListNode) {
        val = x;
        next = nListNode;
    }
}


public class SolutionGetIntersectionNode {
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode cur1 = headA,cur2=headB;
    //     while (cur1 != cur2) {
    //         if(cur1!=null){
    //             cur1 = cur1.next;
    //         }else cur1 = headA;

    //         if(cur2 != null) cur2 = cur2.next;
    //         else cur2 = headB;
    //     }
    //     return cur1;
    // }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0,lenB = 0;
        // 统计两个链表的长度
        lenA = calculateLength(headA);
        lenB = calculateLength(headB);
        int diff = Math.abs(lenA-lenB);
        if (lenA < lenB){
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        ListNode curA = headA,curB = headB;
        while (diff > 0) {
            curA = curA.next;
            diff--;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    private int calculateLength(ListNode head){
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
