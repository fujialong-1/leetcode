package dfs.p131;

import java.util.*;

public class Problem131 {

    static List<List<String>> res = new LinkedList<>();


    public static void main(String[] args) {


        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "清华");
        map.put(2, "北大");
        map.put(1, "华科");
        map.put(3, "武大");

        Set<Integer> s = map.keySet();
        for (Integer i:s) {
            System.out.println(map.get(i));
        }

        //System.out.println((int) '1');

        /*List<Character> list = new LinkedList<>();

        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        if (list.contains('1')) {
            list.remove('1');
        }
        for (char c:list) {
            System.out.println(c);
        }*/



        /*List<List<String>> r = partition("abadffd");
        for (List<String> item : r){
            for (String s:item) {
                System.out.print(s + " ");
            }
            System.out.println();
        }*/


    }



    public static List<List<String>> partition(String s) {
        LinkedList<String> ls = new LinkedList<>();
        backtrack(s, ls);
        return res;
    }

    public static void backtrack(String s, LinkedList<String> track) {

        /*System.out.println("----------------");
        System.out.println("队列中的元素为：");
        for (String it : track) {
            System.out.println(it);
        }
        System.out.println("字符串为：");
        System.out.println(s);
        System.out.println("----------------");*/

        // 触发结束条件
        if (s.length() == 1) {
            track.add(s);
            res.add(new LinkedList(track));
            track.removeLast();
            return;
        }
        if(isWord(s)) {
            track.add(s);
            res.add(new LinkedList(track));
            track.removeLast();
        }

        for (int i = 0; i < s.length() - 1; i++) {
            // 排除不合法的选择
            if (!isWord(s.substring(0, i+1)))
                continue;
            // 做选择
            track.add(s.substring(0, i+1));
            // 进入下一层决策树
            backtrack(s.substring(i+1, s.length()), track);
            // 取消选择
            track.removeLast();
        }
    }

    // 写一个函数判断某字符串是否为回文串
    public static boolean isWord(String item) {
        if(item.length() == 1) return true;
        int left = 0;
        int right = item.length() - 1;
        while(left <= right) {
            if(item.charAt(left) != item.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
