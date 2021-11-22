package top100;

import java.util.List;
import java.util.PriorityQueue;

public class Problem23 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        // 优先级队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) {
                priorityQueue.add(temp.next);
            }
        }
        return dummy.next;
    }
}
