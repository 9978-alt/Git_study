public class SolutionIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        int len = calculateLength(head);
        if (len <= 1) return true;
        ListNode[] reverseList = reverseList(head,len / 2);
        ListNode cur = reverseList[0];
        ListNode reverseCur = reverseList[1];
        if(len % 2 != 0) cur = cur.next;
        while (cur != null && reverseCur !=null) {
            if (cur.val != reverseCur.val) return false;
            cur = cur.next;
            reverseCur = reverseCur.next;
        }
        return true;
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

    public ListNode[] reverseList(ListNode head,int k) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = head,next=null;
        while (cur!= null && k > 0) {
            next = cur.next;
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            cur = next;
            k--;
        }
        head = next;
        // printList(head);
        // System.out.println();
        // printList(dummyNode.next);
        return new ListNode[]{head,dummyNode.next};
    }

    public void printList(ListNode head){
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
    }
}
