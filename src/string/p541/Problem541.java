package string.p541;

public class Problem541 {
    public static void main(String[] args) {
//        StringBuffer s = new StringBuffer();
//        s.append("abc");
//        s.reverse();
//        System.out.println(s);
//        String s = "hello";
//        System.out.println(s.substring(0,2));
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("a", 2));
    }
}
//反转字符串 II
class Solution {
    public String reverseStr(String s, int k) {
        int left = 0;
        int right = s.length();
        StringBuffer res = new StringBuffer();
        while (left < right) {
            if (right - left < k) {
                StringBuffer temp = new StringBuffer();
                temp.append(s.substring(left, right));
                temp.reverse();
                res.append(temp);
                left += 2*k;
            } else if (right - left >= 2*k) {
                StringBuffer temp = new StringBuffer();
                temp.append(s.substring(left, left + k));
                temp.reverse();
                res.append(temp);
                res.append(s.substring(left + k, left + 2*k));
                left += 2*k;
            } else {
                StringBuffer temp = new StringBuffer();
                temp.append(s.substring(left, left + k));
                temp.reverse();
                res.append(temp);
                res.append(s.substring(left + k, right));
                left += 2*k;
            }
        }
        return res.toString();
    }
}