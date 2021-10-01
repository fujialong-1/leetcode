package linkedlist.p25;

// 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
// k 是一个正整数，它的值小于或等于链表的长度。
public class Problem25 {
    public static void main(String[] args) {



    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode a, b;
        a = b = head;
        for(int i = 0; i < k; i++) {
            // 不足k个，不需要反转
            if(b == null) return head;
            b = b.next;
        }
        ListNode newNode = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newNode;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = nxt = a;
        while(cur != b) {
            // 完成交换
            nxt = cur.next;
            cur.next = pre;
            // 前移
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
