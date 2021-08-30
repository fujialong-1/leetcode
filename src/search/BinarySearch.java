package search;

public class BinarySearch {

    public static void main(String[] args) {


        int[] nums = {1, 3, 5, 6, 7, 8, 4, 0};
        int target = 8;
        System.out.println(binarySearch(nums, target));

    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

}
