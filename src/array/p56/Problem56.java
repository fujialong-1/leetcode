package array.p56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem56 {

    public static void main(String[] args) {
        int[][] exa = new int[][]{
                {1, 4}, {2, 3}
        };
        System.out.println(exa[0][0]);
        System.out.println(exa[0][1]);
        quickSort(exa, 0, 1);
        for (int[] item : exa) {
            System.out.println(Arrays.toString(item));
        }

        //System.out.println(Arrays.toString(exa));
    }

    public static int[][] merge(int[][] intervals) {
        // 搞清楚数学过程
        // 搞一个栈
        // 先按左区间大小排序
        // 用栈实现
        // 先用快排
        int n = intervals.length;
        quickSort(intervals, 0, n - 1);
        Stack<Integer> s = new Stack<>();
        List<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(s.isEmpty()) {
                s.push(intervals[i][0]);
                s.push(intervals[i][1]);
            } else {
                int temp = intervals[i][0];
                if(temp > s.peek()) {
                    int num1 = s.pop();
                    int num2 = s.pop();
                    Integer[] item = new Integer[]{num2, num1};
                    list.add(item);
                    s.push(intervals[i][0]);
                    s.push(intervals[i][1]);
                } else {
                    int a = intervals[i][1];
                    if (a >= s.peek()) {
                        s.pop();
                        s.push(intervals[i][1]);
                    }
                }
            }
        }
        int num1 = s.pop();
        int num2 = s.pop();
        Integer[] last = new Integer[]{num2, num1};
        list.add(last);
        int m = list.size();
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < m; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    public static void quickSort(int[][] tar, int low, int high) {
        if(low > high) return;
        int i = low;
        int j = high;
        int temp = tar[i][0];
        int temp2 = tar[i][1];
        while(i < j) {
            while(i < j && tar[j][0] >= temp) {
                j--;
            }
            while(i < j && tar[i][0] <= temp) {
                i++;
            }
            if(i < j) swap(tar, i, j);
        }
        tar[low][0] = tar[i][0];
        tar[low][1] = tar[i][1];
        tar[i][0] = temp;
        tar[i][1] = temp2;
        quickSort(tar, low, i - 1);
        quickSort(tar, i + 1, high);
    }

    public static void swap(int[][] a, int i, int j) {
        int temp1 = a[i][0];
        int temp2 = a[i][1];
        a[i][0] = a[j][0];
        a[i][1] = a[j][1];
        a[j][0] = temp1;
        a[j][1] = temp2;
    }
}
