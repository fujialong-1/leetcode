package array.p69;

public class Problem69 {
    public static void main(String[] args) {

    }
}

class Solution {
    //69. x的平方根
    public int mySqrt(int x) {
        int left = 1, right = x;
        int ans = -1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(x/mid == mid){
                ans = mid;
                return ans;
            } else if (x/mid > mid){
                left = mid + 1;
            } else if (x/mid < mid){
                right = mid -1;
            }
        }
        return right;
    }
}
