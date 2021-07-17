package array.p84;

public class Problem84 {
    public static void main(String[] args) {

    }
}

class Solution {
    //844. 比较含退格的字符串
    public boolean backspaceCompare(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int fastIndex1 = 0;
        int slowIndex1;
        for (slowIndex1 = 0; fastIndex1 < sc.length; fastIndex1++){
            if(sc[fastIndex1] != '#'){
                sc[slowIndex1] = sc[fastIndex1];
                slowIndex1++;
            } else {
                slowIndex1--;
                if (slowIndex1 < 0){
                    slowIndex1 = 0;
                }
                sc[slowIndex1] = ' ';
            }
        }
        int fastIndex2 = 0;
        int slowIndex2;
        for (slowIndex2 = 0; fastIndex2 < tc.length; fastIndex2++){
            if(tc[fastIndex2] != '#'){
                tc[slowIndex2] = tc[fastIndex2];
                slowIndex2++;
            } else {
                slowIndex2--;
                if (slowIndex2 < 0){
                    slowIndex2 = 0;
                }
                tc[slowIndex2] = ' ';
            }
        }

        if (slowIndex1 != slowIndex2){
            return false;
        } else {
            for (int i = 0; i < slowIndex1; i++){
                if (sc[i] != tc[i]){
                    return false;
                }
            }
            return true;
        }
    }
}