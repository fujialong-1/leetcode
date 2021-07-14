public class slide_window {
}

class Solution3{

    // 滑动窗口
    //209. 长度最小的子数组
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //
    public int totalFruit(int[] fruits) {
        int left = 0;
        int sum = 0;
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < fruits.length; right++){
            if (sum == 0){
                sum++;
                n1 = fruits[right];
                result = right - left;
            } else if (sum == 1){
                if (fruits[right] != fruits[left]){
                    sum++;
                    n2 = fruits[right];
                }
                result = right - left;
            } else if (sum == 2){
                if (fruits[right] != n1 && fruits[right] != n2){

                }
            }
        }
        return 0;
    }

    //59. 螺旋矩阵

}