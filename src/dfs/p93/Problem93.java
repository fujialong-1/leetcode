package dfs.p93;

import java.util.LinkedList;
import java.util.List;

public class Problem93 {

    static List<String> result = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {


        System.out.println(Integer.valueOf("013"));

        /*StringBuilder sb = new StringBuilder();
        sb.append("0");
        sb.append("1");
        sb.append("2345");
        sb.delete(3, sb.length());
        System.out.println(sb.toString());*/

        //System.out.println(isValid("14"));


        //String s = "0000";
        /*String s = "101023";
        List<String> res = restoreIpAddresses(s);
        for (String item:res) {
            System.out.println(item);
        }*/
//        String s = "25525511135";
//        restoreIpAddresses(s);
        System.out.println(isValid("010"));
        System.out.println(isValid("255"));
        System.out.println(isValid("2552"));
        restoreIpAddresses("010010");
    }



    public static List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }
    public static void backtracking(String s, int index, int length) {

        if(length > 4) {
            return;
        }
        if(length == 4 && index < s.length()) {
            return;
        }
        if(length == 4 && index == s.length()) {
            result.add(sb.toString());
            return;
        }
        for(int i = index; i < index + 3 && i < s.length(); i++) {
            if(isValid(s.substring(index, i+1))) {
                int sbLength = sb.length();
                if(length == 3) {
                    sb.append(s.substring(index, i+1));
                    backtracking(s, i+1, length+1);
                    sb.delete(sbLength, sbLength+i-index+1);
                } else {
                    sb.append(s.substring(index, i+1));
                    sb.append('.');
                    backtracking(s, i+1, length+1);
                    sb.delete(sbLength, sbLength+i-index+2);
                }
            }
        }
    }
    public static boolean isValid(String s) {
        if(s.length() == 1) {
            return true;
        } else {
            if(s.charAt(0) == '0') {
                return false;
            } else {
                int temp = Integer.valueOf(s);
                if(temp <= 255) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
