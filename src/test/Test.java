package test;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        /*int j = 0;
        for (int i = j; i < 10; i++) {
            if (i == 4) {
                System.out.println(j);
            }
            continue;
        }*/
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("123456");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
        stringBuilder.delete(1, 2);
        System.out.println(stringBuilder);
        String s = "123";
        Set<Integer> set = new HashSet<>();
//        set.contains();
    }
}
