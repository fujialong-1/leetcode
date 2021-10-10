package heap;

import java.util.*;
// 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
//
//(注：分数越高的选手，排名越靠前。)
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/relative-ranks
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Problem506 {
    public static void main(String[] args) {

    }
    // 优先队列
    public String[] findRelativeRanks(int[] score) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int temp:score) {
            queue.add(temp);
        }
        int length = score.length;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        String[] res = new String[queue.size()];
        while (!queue.isEmpty()) {
            i++;
            map.put(queue.poll(), i);
        }
        for (int j = 0; j < length; j++) {
            if (map.get(score[j]) == length) {
                res[j] = "Gold Medal";
            } else if (map.get(score[j]) == length-1) {
                res[j] = "Silver Medal";
            } else if (map.get(score[j]) == length-2) {
                res[j] = "Bronze Medal";
            } else {
                res[j] = String.valueOf(length - map.get(score[j]) + 1);
            }
        }
        return res;
    }
}
