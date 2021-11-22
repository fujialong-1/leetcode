package top100;

public class Problem5 {
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        // 中心拓展算法
        int n = s.length();
        int left = 0;
        int right = 0;
        int res = 0;
        for(int i = 0; i < 2 * n - 1; i++) {
            int l = i/2;
            int r = i/2 + i%2;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > res) {
                    left = l;
                    right = r;
                    res = r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(left, right+1);
    }
}
