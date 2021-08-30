package dp.p233;

public class Problem233 {

    public static void main(String[] args) {

        System.out.println(countDigitOne(13));

    }

    // 超时了
    public static int countDigitOne(int n) {
        if(n == 0) return 0;
        int before = 0;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum = before + findOne(i);
            before = sum;
        }
        return sum;
    }

    public static int findOne(int num) {
        String item = String.valueOf(num);
        int res = 0;
        for (int i = 0; i < item.length(); i++) {
            if (item.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }
}
