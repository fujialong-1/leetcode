package search.p35;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/7 22:13
 */
public class Problem35 {

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high) {
            int middle = (low + high)/2;
            if(target == nums[middle]) {
                return middle;
            } else if(target > nums[middle]) {
                low = middle + 1;
            } else if(target < nums[middle]) {
                high = middle;
            }
        }
        return high;
    }
}
