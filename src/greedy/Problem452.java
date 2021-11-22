package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem452 {
    public static void main(String[] args) {

        int[][] test = new int[][] {
                {10, 6}, {2, 8}, {1, 6}, {7, 12}, {2, 3}, {2, 5}
//                {-2147483646, -2147483645}, {2147483646, 2147483647}
        };
        Arrays.sort(test, (o1, o2) -> Integer.compare(o1[0], o2[0]));
//        Arrays.sort(test, (a, b) -> {
//            if(a[0] == b[0]) {
//                return a[1] - b[1];
//            }
//            return a[0] - b[0];
//        });
//        Arrays.sort(test, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        for (int[] temp : test) {
            System.out.println(Arrays.toString(temp));
        }

    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int n = points.length;
        int res = n;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= points[index][1]) {
                res--;
            } else {
                index = i;
            }
        }
        return res;
    }
}
