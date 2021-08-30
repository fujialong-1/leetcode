package linkedlist.p06;


public class Problem06 {
}


// 剑指 Offer 06. 从尾到头打印链表
class Solution {
    public int[] reversePrint(ListNode head) {
        /*Stack<Integer> stack = new Stack<Integer>();
        ListNode cur = head;
        while (null != cur) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;*/

        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while(currNode != null){
            len ++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while(currNode != null){
            result[len - 1] = currNode.val;
            len --;
            currNode = currNode.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
