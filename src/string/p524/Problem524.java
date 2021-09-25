package string.p524;

import java.util.LinkedList;
import java.util.List;


//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
//如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Problem524 {

    public static void main(String[] args) {
        //"ale","apple","monkey","plea"
        //System.out.println(isChildWord("abpcplea", "plea"));
        String s = "abpcplea";
        //String[] strings = {"ale","apple","monkey","plea"};
        List<String> dictionary = new LinkedList<>();
        dictionary.add("app");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        dictionary.add("abc");

        System.out.println(findLongestWord(s, dictionary));


    }

    // 思路：
    // 1、遍历字符串数组中的每个字符串，写一个函数判断该字符串能否通过删除s中的某些字符得到
    public static String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String item : dictionary) {
            if (isChildWord(s, item)) {
                if (item.length() > res.length()) {
                    res = item;
                } else if (item.length() == res.length()) {
                    res = res.compareTo(item) < 0 ? res : item;
                }
            }
        }
        return res;
    }

    public static boolean isChildWord(String s, String target) {
        if (target.length() > s.length()) return false;
        // 双指针
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == target.length();
    }
}
