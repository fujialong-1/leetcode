package linkedlist.p2;

public class Problem2 {

    public static void main(String[] args) {

    }
    // 两数相加
    // 思路：同时遍历两链表，将数字之和加起来保存在新节点中，再用一个boolean来记录是否进位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int temp= 0;
        boolean flag = false;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null && temp2 != null) {
            if (flag) {
                // 有进位
                temp = temp1.val + temp2.val + 1;
                if (temp >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                // 无进位
                temp = temp1.val + temp2.val;
                if (temp >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while (temp2 != null) {
            if (flag) {
                // 有进位
                temp = temp2.val + 1;
                if (temp >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                // 无进位
                temp = temp2.val;
                if (temp >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            temp2 = temp2.next;
        }
        while (temp1 != null) {
            if (flag) {
                // 有进位
                temp = temp1.val + 1;
                if (temp >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                // 无进位
                temp = temp1.val;
                if (temp >= 10) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
            cur.next = new ListNode(temp%10);
            cur = cur.next;
            temp1 = temp1.next;
        }
        if (flag) {
            cur.next = new ListNode(1);
            cur = cur.next;
        }
        return head.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
