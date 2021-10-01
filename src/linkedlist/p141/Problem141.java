package linkedlist.p141;

// 判断环形链表
public class Problem141 {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        // 快慢指针
        ListNode slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
