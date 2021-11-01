package dp.p5;

public class Problem5 {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("cbbbc"));

    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int res, left, right;
        res = left = right = 0;
        for(int i = 0; i < 2*n-1; i++) {
            int l = i/2;
            int r = i/2 + i%2;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r-l+1 > res) {
                    res = r-l+1;
                    left = l;
                    right = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(left, right+1);
    }
}
