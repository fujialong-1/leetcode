public class binary_search {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }


    //二分查找
    public static int search(int[] nums, int target){
        if(target < nums[0] || target > nums[nums.length-1]){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int middle = left + (right-left)/2;
            if(nums[middle] == target){
                return middle;
            } else if (nums[middle] > target){
                right = middle-1;
            } else if (nums[middle] < target){
                left = middle+1;
            }
        }
        return -1;
    }
    //69 x的平方根
    public static int mySqrt(int x){
        int i = 0;
        while((i * i) <= x){
            i++;
        }
        return i-1;
    }

}