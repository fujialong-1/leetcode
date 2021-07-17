package linkedlist.p19;

public class Problem19 {
    public static void main(String[] args) {

    }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        ListNode slowNode = new ListNode();
        ListNode fastNode = new ListNode();
        dummyNode.next = head;
        slowNode.next = head;
        fastNode.next = head;
        for(int i = 1; i <= n ; i++){
            fastNode = fastNode.next;
        }
        while(fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}