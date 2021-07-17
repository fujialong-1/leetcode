package string.p344;

public class Problem344 {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        Solution solution = new Solution();
        solution.reverseString(s);
        System.out.println(s);
    }
}
//反转字符串
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp = ' ';
        while (left <= right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
