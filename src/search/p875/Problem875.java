package search.p875;

public class Problem875 {
    public static void main(String[] args) {

        int[] piles = new int[]{3, 6, 7, 11};
        System.out.println(minEatingSpeed(piles, 8));

    }


    public static int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }

    // Can Koko eat all bananas in H hours with eating speed K?

    /**
     * boolean 很妙
     * @param piles
     * @param H
     * @param K
     * @return
     */
    public static boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles) {
            time += (p-1) / K + 1;
        }
        return time <= H;
    }
}
