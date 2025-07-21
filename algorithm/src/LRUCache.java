import java.util.*;

public class LRUCache {
    // 双向链表的节点
    class DNode{
        int key;
        int val;
        DNode prev;
        DNode next;
        public DNode(){}
        public DNode(int key,int val){
            this.key = key;
            this.val = val;
        }
        public DNode(int key,int val,DNode prev,DNode next){
            this(key, val);
            this.prev = prev;
            this.next = next;
        }
    }

    int capacity;   // 最大容量
    int size; // 目前的容量
    Map<Integer,DNode> map;
    DNode head,tail;// 哑节点

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        DNode node = map.get(key);
        if(node == null) return -1;
        // moveToHead(node); 
        return node.val;
    }
    
    public void put(int key, int value) {
        DNode node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.val = value;
            map.put(key, node);
            moveToHead(node);
        }else {
            node = new DNode(key,value);
            map.put(key, node);
            size++;
            addToHead(node);
            if(size > capacity){
                int dkey = deleteTail();
                map.remove(dkey);
                size--;
            }
        }
    }

    public void moveToHead(DNode node){
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(DNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int deleteTail(){
        DNode node = tail.prev;
        removeNode(node);
        return node.key;
    }
}
