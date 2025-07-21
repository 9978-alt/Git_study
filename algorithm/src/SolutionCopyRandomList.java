import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class SolutionCopyRandomList {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node dummyNode = new Node(-1),tail = dummyNode;
        Node cur = head;
        // 正常复制next指针，并将新节点和老节点放入map中
        while (cur!=null) {
            Node newCur = new Node(cur.val);
            map.put(cur, newCur);
            dummyNode.next = newCur;
            cur = cur.next;
            tail = tail.next;
        }
        // 复制random指针
        cur = head;
        tail = dummyNode.next;
        while (cur!=null) {
            Node random = cur.random;
            tail.random = map.get(random);
            cur = cur.next;
            tail = tail.next;
        }
        return dummyNode.next;
    }
}
