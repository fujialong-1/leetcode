package linkedlist.p876;

// 链表中点
public class Problem876 {
    public static void main(String[] args) {

    }
    public ListNode middleNode(ListNode head) {
        // 双指针
        ListNode slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}