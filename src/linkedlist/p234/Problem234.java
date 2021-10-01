package linkedlist.p234;
// 判断回文链表
public class Problem234 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode fast, slow;
        fast = slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre, cur;
        pre = null;
        cur = head;
        while(cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

