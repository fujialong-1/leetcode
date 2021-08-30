package string.p1422;

public class Problem1422 {
    public static void main(String[] args) {

        String s = new String("00010100011001010");
        char[] c = s.toCharArray();
        int a = c[0] - 'a';
        System.out.println(a);
        int[] num_zero = new int[c.length];
        int number = 0;
        for(int i = 0; i < num_zero.length; i++) {
            if (c[i] == '0') {
                number++;
                num_zero[i] = number;
            } else {
                num_zero[i] = number;
            }
        }
        for (int i:num_zero) {
            System.out.println(i);
        }
    }

    /*public static int maxScore(String s) {
        char[] c = s.toCharArray();
        int[] num_zero = new int[c.length];
        for(int i = 0; i < num_zero.length; i++) {
            if(i == 0) {
                if(c[i] == '0') {
                    num_zero[0] = 1;
                }
            } else {
                if(c[i] == '0') {
                    num_zero[i] = num_zero[i-1] + 1;
                }
            }
        }
        int result = 0;
        int temp = 0;
        for(int i = 0; i < num_zero.length-1; i++) {
            temp = num_zero[i] + (num_zero.length - num_zero[num_zero.length-1]) - (i+1-num_zero[i]);
            if(temp > result) result = temp;
        }
        return result;
    }*/
}
