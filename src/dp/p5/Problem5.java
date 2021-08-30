package dp.p5;

public class Problem5 {

    public static void main(String[] args) {


        System.out.println(longestPalindrome("cbbbc"));



    }

    public static String longestPalindrome(String s) {

        int length = s.length();
        if (length < 2) {
            return s;
        }

        // 定义动规数组 dp[i][j]表示s[i~j]子串是否为回文串
        boolean[][] dp = new boolean[length][length];
        // 初始化
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxLength = 0;
        int[] res = new int[2];

        for (int L = 2; L <= length; L++) {
            for (int i = 0; i <= length - L; i++) {
                int j = i + L - 1;
                if (L == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j]) {
                    if (L > maxLength) {
                        maxLength = L;
                        res = new int[]{i, j};
                    }
                }
            }
        }
        //System.out.println(dp[0][4]);
        return s.substring(res[0], res[1] + 1);
    }
}
