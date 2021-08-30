package linkedlist.p206;

import java.util.List;

public class Problem206 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode newNode = Solution.reverseList(n1);
        ListNode cur = newNode;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

class Solution {
    // 反转单链表

    // 迭代法+指针
    /*public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }*/

    // 递归
    public static ListNode reverseList(ListNode head) {
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        ListNode newList = reverseList(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        ListNode t1 = head.next;
        // 让 2 的 next 指向 2
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
