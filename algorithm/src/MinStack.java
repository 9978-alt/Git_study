import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

//class MinStack {
//
//    Deque<Integer> stack;
//    Deque<Integer> minStack;
//    public MinStack() {
//        stack = new LinkedList<>();
//        minStack = new LinkedList<>();
//    }
//
//    public void push(int val) {
//        stack.push(val);
//        minStack.push(Math.min(minStack.peek(),val));
//    }
//
//    public void pop() {
//        stack.pop();
//        minStack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}

class MinStack {
    static class Node{
        int val;
        int min;
        Node next;
        public Node(int val,int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    private Node head;
    public MinStack() {
        head = new Node(-1,Integer.MAX_VALUE);
    }

    public void push(int val) {
        if(head.next == null){
            head.next = new Node(val, val);
        }else {
            int min = Math.min(head.next.min,val);
            Node node = new Node(val, min);
            node.next = head.next;
            head.next = node;
        }
    }

    public void pop() {
        head.next = head.next.next;
    }

    public int top() {
        return head.next.val;
    }

    public int getMin() {
        return head.next.min;
    }
}