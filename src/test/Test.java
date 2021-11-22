package test;

public class Test {
    public static void main(String[] args) {
        int j = 0;
        for (int i = j; i < 10; i++) {
            if (i == 4) {
                System.out.println(j);
            }
            continue;
        }
    }
}
