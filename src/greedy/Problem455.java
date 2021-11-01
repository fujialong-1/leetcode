package greedy;

import java.util.Arrays;

/**
 * 分发饼干
 */
public class Problem455 {
    public static void main(String[] args) {
        int[] test = new int[]{2, 4, 1, 3};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        int res = 0;
        while (j >= 0 && i >= 0) {
            if(s[j] >= g[i]) {
                j--;
                i--;
                res++;
            } else {
                i--;
            }
        }
        return res;
    }
}
