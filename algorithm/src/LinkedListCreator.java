public class LinkedListCreator {
    // 由数组创建链表
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;  // 数组为空时，返回空链表
        }

        // 创建头节点（第一个元素）
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;  // 用于遍历链表的指针

        // 遍历数组剩余元素，创建节点并连接
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);  // 新建节点并连接到当前节点的next
            current = current.next;  // 移动指针到下一个节点
        }

        return head;  // 返回链表的头节点
    }

    // 测试方法：打印链表（验证结果）
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();  // 换行
    }

    // 主方法测试
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(arr);
        printLinkedList(head);  // 输出：1 -> 2 -> 3 -> 4 -> 5
    }
}