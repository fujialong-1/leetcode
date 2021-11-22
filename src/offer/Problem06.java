package offer;

import java.util.Arrays;

public class Problem06 {
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        // 空数组的构造
        if(head == null) return new int[]{};
        // 反转链表
        // 采用迭代方式反转
        ListNode pre, cur;
        pre = null;
        cur = head;
        int num = 0;
        while(cur != null) {
            num++;
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        int[] res = new int[num];
        for(int i = 0; i < num; i++) {
            res[i] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
