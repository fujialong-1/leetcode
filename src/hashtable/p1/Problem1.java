package hashtable.p1;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0){
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = i;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
