package array.p167;
// 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
public class Problem167 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        // 左右指针
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            } else if(sum < target) {
                left++;
            } else if(sum > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
