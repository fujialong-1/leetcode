package string.p151;

public class Problem151 {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.length());
    }
}

class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return " ";
        }
        StringBuffer str = new StringBuffer();
        int left = 0;
        int right = 1;
        while (left < s.length()) {
            while (left < s.length() && !" ".equals(String.valueOf(s.charAt(left)))) {
                right++;
                while (right < s.length() && !" ".equals(String.valueOf(s.charAt(right)))) {
                    right++;
                }
                StringBuffer temp = new StringBuffer();
                temp.append(s.substring(left, right));
//                temp.reverse();
                str.append(temp);
                right++;
                left = right;
                right++;
            }
            left++;
            right++;
        }
        return str.toString();
    }
}

