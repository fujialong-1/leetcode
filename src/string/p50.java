package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class p50 {

    public static void main(String[] args) {
        /*Stack<Integer> s = new Stack<>();
        String a = "123";
        a.length();*/

        String a = "1";
        String b = "111";
        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(m >= 0 && n >= 0) {
            int sum = 0;
            int i = a.charAt(m) - '0';
            int j = b.charAt(n) - '0';
            sum = i + j + count;
            if(sum >= 2) {
                count = 1;
            } else {
                count = 0;
            }
            sb.append(sum%2);
            m--;
            n--;
        }
        while (m >= 0) {
            int sum = 0;
            int i = a.charAt(m) - '0';
            sum = i + count;
            if(sum >= 2) {
                count = 1;
            } else {
                count = 0;
            }
            sb.append(sum%2);
            m--;
        }
        while (n >= 0) {
            int sum = 0;
            int i = b.charAt(n) - '0';
            sum = i + count;
            if(sum >= 2) {
                count = 1;
            } else {
                count = 0;
            }
            sb.append(sum%2);
            n--;
        }
        if(count == 1) sb.append('1');
        return sb.reverse().toString();
    }

    /*public static char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (char item:c) {
            if (map.containsKey(item)) {
                int value = map.get(item);
                value++;
                map.put(item, value);
            } else {
                map.put(item, 1);
            }
        }
        for (char item:c) {
            int value = map.get(item);
            if (value == 1) return item;
        }
        return ' ';
    }*/

    public char firstUniqChar(String s) {



        if(s == "") return ' ';
        // 找一个数组记录每个单词出现的次数以及下标
        int[][] temp = new int[26][2]; // 第一行记录个数，第二行记录出现的位置
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            int index = c[i] - 'a';
            temp[index][0]++;
            temp[index][1] = i;
        }
        int index = 50000;
        for(int i = 0; i < 26; i++) {
            if(temp[i][0] == 1) {
                if(temp[i][1] < index) {
                    index = temp[i][1];
                }
            }
        }
        if(index == 50000) return ' ';
        return c[index];
    }
}
