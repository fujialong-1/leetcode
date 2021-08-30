package dp.p72;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem72 {
    public static void main(String[] args) {

        List<String> temp = generateParenthesis(3);
        for (String s:temp) {
            System.out.println(s);
        }

    }

    /*public static List<String> generateParenthesis(int n) {

        List<List<String>> resSet = new LinkedList<>();

        List<String> item0 = new LinkedList<>();
        item0.add("");
        resSet.add(item0);

        List<String> item1 = new LinkedList<>();
        item1.add("()");
        resSet.add(item1);

        for (int i = 2; i <= n; i++) {
            List<String> res = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> list1 = resSet.get(j);
                List<String> list2 = resSet.get(i-1-j);
                for (String s1 : list1) {
                    for (String s2 : list2) {
                        String s = "(" + s1 + ")" + s2;
                        res.add(s);
                    }
                }

            }
            resSet.add(res);
        }
        return resSet.get(n);
    }*/

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;

    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }
}
