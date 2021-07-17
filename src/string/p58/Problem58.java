package string.p58;

public class Problem58 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuffer substr1 = new StringBuffer();
        StringBuffer substr2 = new StringBuffer();
        substr1.append(s.substring(0, n));
        substr2.append(s.substring(n, s.length()));
        substr2.append(substr1);
        return substr2.toString();
    }
}