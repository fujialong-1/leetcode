package hashtable.p242;

public class Problem242 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isAnagram("asdf", "dfsa"));
    }
}
//有效的字母异位词
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = s.toCharArray();
        for(int i = 0; i < sc.length; i++){
            record[sc[i]-'a']++;
        }
        for(int i = 0; i < tc.length; i++){
            record[tc[i]-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(record[i] != 0){
                return false;
            }
        }
        return true;
    }
}