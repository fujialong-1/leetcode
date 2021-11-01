package greedy;

/**
 * 买卖股票的最佳时机 II
 * 大道至简
 */
public class Problem122 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            if(prices[i+1] > prices[i]) {
                res += prices[i+1] - prices[i];
            }
        }
        return res;
    }
}
