package test1;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
我对所有人说： 04:07 PM
好像卡了
Zhuchengtao z00314494对所有人说说： 05:14 PM
给你两个长度相同的字符串，s 和 t。

将s中的第i个字符变到t中的第 i 个字符需要|s[i] - t[i]|的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。

用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。

如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。

如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。

示例 1：

输入：s = "abcd", t = "bcdf", maxCost = 3
输出：3
解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。


示例 2：

输入：s = "abcd", t = "cdef", maxCost = 3
输出：1
解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。


示例 3：

输入：s = "abcd", t = "acde", maxCost = 0
输出：1
解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。

* */
// 奥运会奖牌榜排名，现在我们假设奖牌榜的排名规则如下：
//
//1、首先gold medal数量多的排在前面；
//2、其次silver medal数量多的排在前面；
//3、然后bronze medal数量多的排在前面；
//4、若以上三个条件仍无法区分名次，则以国家名称的字典序排定。
//我们假设国家名称不超过20个字符、各种奖牌数不超过100，且大于等于0。
//
//解答要求
//时间限制：1000ms, 内存限制：100MB
//输入
//第一行输入一个整数N(0<N<21)，代表国家数量;
//然后接下来的N行，每行包含一个字符串Namei表示每个国家的名称，和三个整数Gi、Si、Bi表示每个获得的gold medal、silver medal、bronze medal的数量，以空格隔开，如(China 51 20 21)，具体见样例输入。
//
//输出
//输出奖牌榜的依次顺序，只输出国家名称，各占一行，具体见样例输出。
//
//样例
//输入样例 1
//
//5
//China 32 28 34
//England 12 34 22
//France 23 33 2
//Japan 12 34 25
//Rusia 23 43 0
//
//
//输出样例 1
//
//China
//Rusia
//France
//Japan
//England
public class Main {
    public static void main(String[] args) {

//        function("abcd", "bcdf", 3);

        Country temp1 = new Country("China", 32, 28, 34);
        Country temp2 = new Country("England", 12, 34, 22);
        Country temp3 = new Country("France", 23, 33, 2);
        Country temp4 = new Country("Japan", 12, 34, 25);
        Country temp5 = new Country("Rusia", 23, 43, 0);
        Country temp6 = new Country("America", 12, 34, 22);

        List<Country> list = new ArrayList<>();
        list.add(temp1);
        list.add(temp2);
        list.add(temp3);
        list.add(temp4);
        list.add(temp5);
        list.add(temp6);
        list.sort((b, a) -> {
            if (a.golden != b.golden) {
                return a.golden - b.golden;
            }
            if (a.sliver != b.sliver) {
                return a.sliver - b.sliver;
            }
            if (a.cu != b.cu) {
                return a.cu - b.cu;
            }
            return b.countryName.compareTo(a.countryName);
        });
        for (Country country : list) {
            System.out.println(country.countryName);
        }
    }

    private static int res;

    public static void function(String t, String s, int maxCost) {
        bfs(t, s, 0, maxCost, 0);
        System.out.println(res);
    }

    public static void bfs(String t, String s, int index, int cost, int count) {
        if (index >= t.length()) {
            return;
        }
        int tempCost = s.charAt(index) - t.charAt(index);
        tempCost = tempCost > 0 ? tempCost : -tempCost;
        if (cost >= tempCost) {
            bfs(t, s, index+1, cost-tempCost, ++count);
        } else {
            res = Math.max(res, count);
            bfs(t, s, index + 1, cost, 0);
        }
    }

}

class Country {

    String countryName;
    int golden;
    int sliver;
    int cu;

    public Country(String countryName, int golden, int sliver, int cu) {
        this.countryName = countryName;
        this.golden = golden;
        this.sliver = sliver;
        this.cu = cu;
    }
}
