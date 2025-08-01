public class SolutionAddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        if(l1==null) return l2;
        if(l2 == null) return l1;
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null?0:l1.val;
            int num2 = l2 == null?0:l2.val;
            carry = (num1 + num2 + carry) / 10;
            int num = (num1 + num2 + carry) % 10;
            tail.next = new ListNode(num);
            tail = tail.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry != 0) tail.next = new ListNode(carry);
        return dummyNode.next;
    }
}
