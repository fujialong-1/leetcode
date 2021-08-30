package dfs.p1722;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem1722 {

    public static void main(String[] args) {

        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList(
                "si","go","se","cm","so","ph","mt","db",
                "mb","sb","kr","ln","tm","le","av","sm",
                "ar","ci","ca","br","ti","ba","to","ra",
                "fa","yo","ow","sn","ya","cr","po","fe",
                "ho","ma","re","or","rn","au","ur","rh",
                "sr","tc","lt","lo","as","fr","nb","yb",
                "if","pb","ge","th","pm","rb","sh","co",
                "ga","li","ha","hz","no","bi","di","hi",
                "qa","pi","os","uh","wm","an","me","mo",
                "na","la","st","er","sc","ne","mn","mi",
                "am","ex","pt","io","be","fm","ta","tb",
                "ni","mr","pa","he","lr","sq","ye");
        List<String> res = findLadders(beginWord, endWord, wordList);
        for (String s:res) {
            System.out.println(s);
        }

        //System.out.println(isOne("1234", "1237"));

    }

    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> track = new LinkedList<String>();
        track.add(beginWord);
        if (permute(beginWord, endWord, track, wordList)) {
            return track;
        } else {
            return new LinkedList<>();
        }
    }

    public static boolean permute(String curWord, String endWord, LinkedList<String> track, List<String> wordList) {
        if (curWord.equals(endWord)) {
            return true;
        }

        // 从选择列表中做选择
        for (String item : wordList) {
            if (!track.contains(item)) {
                if (isOne(item, curWord)) {
                    track.add(item);
                    if (permute(item, endWord, track, wordList)) return true;
                    track.removeLast();
                }
            }
        }
        return false;
    }

    // 判断两个字符串是否只相差一个字符
    public static boolean isOne(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int num = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                num++;
            }
        }
        return num == 1;
    }
}
