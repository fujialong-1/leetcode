package test;

public class Test1 {

    public static void main(String[] args) {
        //int a = 1;
        //System.out.println(~a);
        //System.out.println(1<<6);
        /*System.out.println(Integer.bitCount(4));
        String s = "adf";
        System.out.println(1 + s.charAt(0));
        char c = 97;
        System.out.println(c);*/


        System.out.println(isPrime(1357));
    }

    public static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
