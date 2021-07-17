package hashtable.p383;

import java.util.HashMap;
import java.util.Map;

public class Problem383 {
    public static void main(String[] args) {

    }
}

//赎金信
//map解法
class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        char[] c1 = ransomNote.toCharArray();
        char[] c2 = magazine.toCharArray();
        for(int i = 0; i < c1.length; i++){
            if(map1.containsKey(c1[i])){
                map1.put(c1[i], map1.get(c1[i])+1);
            } else {
                map1.put(c1[i], 1);
            }
        }
        for(int i = 0; i < c2.length; i++){
            if(map2.containsKey(c2[i])){
                map2.put(c2[i], map2.get(c2[i])+1);
            } else {
                map2.put(c2[i], 1);
            }
        }
        for(int i = 0; i < c1.length; i++){
            if(!map2.containsKey(c1[i]) || map2.get(c1[i]) < map1.get(c1[i]) ){
                return false;
            }
        }
        return true;
    }
}

//数组解法
class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        //记录杂志字符串出现的次数
        int[] arr = new int[26];
        int temp;
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i) - 'a';
            arr[temp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i) - 'a';
            //对于金信中的每一个字符都在数组中查找
            //找到相应位减一，否则找不到返回false
            if (arr[temp] > 0) {
                arr[temp]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
