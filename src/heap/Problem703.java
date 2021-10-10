package heap;

import java.util.PriorityQueue;

// 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
//
//请实现 KthLargest 类：
//
//KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
//int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Problem703 {
    public static void main(String[] args) {

    }
}

class KthLargest {

    // 确保队列的容量为k
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
