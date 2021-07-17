package array.p367;

public class Problem367 {
    public static void main(String[] args) {

    }
}

class Solution {
    //367. 有效的完全平方数
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        boolean ans = false;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(num/mid == mid){
                if (num%mid == 0){
                    ans = true;
                    return ans;
                } else {
                    return ans;
                }

            } else if (num/mid > mid){
                left = mid + 1;
            } else if (num/mid < mid){
                right = mid -1;
            }
        }
        return ans;
    }
}
