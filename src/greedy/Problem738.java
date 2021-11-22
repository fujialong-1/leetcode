package greedy;

public class Problem738 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));

    }
    public static int monotoneIncreasingDigits(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        if(cs.length == 1) {
            return n;
        }
        int i = 0;
        while (i < cs.length - 1) {
            if(cs[i] > cs[i+1]) {
                cs[i] = (char) (cs[i] - 1);
                for (int j = i+1; j < cs.length; j++) {
                    cs[j] = '9';
                }
                i = 0;
            } else {
                i++;
            }
        }
        int res = 0;
        for (int j = 0; j < cs.length; j++) {
            res = 10 * res + cs[j] - '0';
        }
        return res;
    }
}
