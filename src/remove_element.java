/*
* 双指针
* */
public class remove_element {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.backspaceCompare("ad#c","ab#c");
    }
}


class Solution2 {

    //27. 移除元素
    public int removeElement(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;

    }

    //26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        } else {
            int fastIndex = 1;
            int slowIndex;
            int val = 0;
            for (slowIndex = 0; fastIndex < nums.length; fastIndex++){
                val = nums[slowIndex];
                if (nums[fastIndex] != val) {
                    slowIndex++;
                    nums[slowIndex] = nums[fastIndex];
                }
            }
            return slowIndex + 1;
        }
    }

    //283. 移动零
    public void moveZeroes(int[] nums) {
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex] != 0){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        for (int i = slowIndex; i < nums.length; i++){
            nums[i] = 0;
        }
    }

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

    //977. 有序数组的平方
//    public int[] sortedSquares(int[] nums) {
//
//    }
}
