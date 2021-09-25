package test;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {

        String test = "a001bc01d8ef34";
        System.out.println(fun(test));

    }

    // 返回不同十进制数的数目
    // 1、首先将小写字母转成空格
    public static int fun(String s) {
        List<String> list = new LinkedList<>();
        //StringBuffer sb = new StringBuffer();
        int length = s.length();
        // 用双指针
        int left = 0;
        int right = left;
        while (left < length) {
            if (s.charAt(left) <= 122 && s.charAt(left) >= 97) {
                left++;
                right = left;
            } else {
                right = left + 1;
                while (right < length && s.charAt(right) <= 57 && s.charAt(right) >= 48) {
                    right++;
                }
                list.add(s.substring(left, right));
                left = right;
                right = left;
            }
        }
        Set<Integer> res = new HashSet<>();
        for (String item:list) {
            int temp = Integer.valueOf(item);
            res.add(temp);
        }
        return res.size();
        /*for (int i = 0; i < length; i++) {
            left = i;
            if (s.charAt(left) <= 122 && s.charAt(left) >= 97) {
                continue;
            } else {

            }
        }*/
    }



}
