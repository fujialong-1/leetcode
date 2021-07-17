package string.p28;

//KMP算法
public class Problem28 {
    public static void main(String[] args) {
        String s = "asdfasdfasdf";
        int[] next = new int[s.length()];
        Solution solution = new Solution();
        solution.getNext(next, s);
        for (int i:next) {
            System.out.println(i);
        }

    }
}

class Solution {
    //next[]求法
    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {// j要保证大于0，因为下面有取j-1作为数组下标的操作
                j = next[j-1];// 注意这里，是要找前一位的对应的回退位置了
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return (i-needle.length()+1);
            }
        }
        return -1;
    }
}
