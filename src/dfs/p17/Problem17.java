package dfs.p17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem17 {

    public static Map<Character, String> map = new HashMap<>();

    public static void main(String[] args) {

        String digits = "23";
        List<String> res = letterCombinations(digits);
        for (String item : res) {
            System.out.println(item);
        }
        System.out.println(Integer.valueOf(digits.charAt(1)));

    }

    public static List<String> letterCombinations(String digits) {

        List<String> res = new LinkedList<>();

        if (digits.length() == 0) return res;
        //Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        permute(res, digits, sb, 0);

        return res;
    }

    public static void permute(List<String> res, String s, StringBuilder sb, int index) {
        // 终止条件
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {

            String temp = map.get(s.charAt(i));

            for (int j = 0; j < temp.length(); j++) {
                sb.append(temp.charAt(j));
                permute(res, s, sb, i+1);
                sb.deleteCharAt(sb.length() - 1);

            }

            /*if (s.charAt(i) == '7') {
                char[] temp = {'p', 'q', 'r', 's'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (s.charAt(i) == '2') {
                char[] temp = {'a', 'b', 'c'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (s.charAt(i) == '3') {
                char[] temp = {'d', 'e', 'f'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (s.charAt(i) == '4') {
                char[] temp = {'g', 'h', 'i'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (s.charAt(i) == '5') {
                char[] temp = {'j', 'k', 'l'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (s.charAt(i) == '6') {
                char[] temp = {'m', 'n', 'o'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (s.charAt(i) == '8') {
                char[] temp = {'t', 'u', 'v'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (s.charAt(i) == '9') {
                char[] temp = {'w', 'x', 'y', 'z'};
                for (int j = 0; j < temp.length; j++) {
                    sb.append(temp[j]);
                    permute(res, s, sb, i+1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }*/

        }
    }
}
