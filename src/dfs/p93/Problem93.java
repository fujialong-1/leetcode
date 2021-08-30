package dfs.p93;

import java.util.LinkedList;
import java.util.List;

public class Problem93 {

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

    }

    public static List<String> restoreIpAddresses(String s) {

        // 将字符串拆成4组
        List<String> res = new LinkedList<String>();

        if (s.length() > 12 || s.length() < 4) {
            return res;
        }

        //List<String> track = new LinkedList<String>();

        StringBuilder sb = new StringBuilder();

        permute(res, sb, s, 0);

        return res;

    }

    public static void permute(List<String> res, StringBuilder sb, String s, int index) {


        // 终止条件
        if ((sb.length() - 4) == s.length() && index == s.length()) {
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }

        for (int i = index+1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (isValid(temp)) {
                int start = sb.length();
                sb.append(temp);
                sb.append(".");
                permute(res, sb, s, i);
                sb.delete(start, sb.length());
            }
        }
    }

    public static boolean isValid(String target) {
        if (target.length() >= 4) {
            return false;
        } else if (target.length() == 1) {
            return true;
        } else if (target.length() == 2) {
            return target.charAt(0) != '0';
        } else {
            if (target.charAt(0) == '0') {
                return false;
            } else {
                int num = Integer.parseInt(target);
                return num <= 255;
            }
        }
    }
}
