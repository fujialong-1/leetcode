package util;

public class Main {

    public static void main(String[] args) {
        System.out.println(findOne(123111));
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
