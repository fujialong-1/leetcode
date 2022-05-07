package dfs.p140;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem140 {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        wordBreak(s, wordDict);
    }

    public static List<String> res = new LinkedList<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder();
        dfs(s, wordDict, 0, sb);
        return res;
    }

    static void dfs(String s, List<String> wordDict, int index, StringBuilder sb) {
        if(index == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for(int i = index + 1; i <= s.length(); i++) {
            int start = sb.length();
            String temp = s.substring(index, i);
            if(wordDict.contains(temp)) {
                sb.append(temp);
                sb.append(' ');
                dfs(s, wordDict, i, sb);
                // 这里其实要做下判断
                if (i == s.length()) {
                    sb.delete(start, start + i - index);
                } else {
                    sb.delete(start, start + i - index + 1);
                }

            }
        }
    }
}
