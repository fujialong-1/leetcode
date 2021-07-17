package hashtable.p202;

import java.util.HashSet;
import java.util.Set;

public class Problem202 {
    public static void main(String[] args) {

    }
}

//快乐数
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while(set.add(sum)){
            sum = 0;
            while(n != 0){
                sum+=(n%10)*(n%10);
                n = n/10;
            }
            n = sum;
            if(sum == 1){
                return true;
            }
        }
        return false;
    }
}
