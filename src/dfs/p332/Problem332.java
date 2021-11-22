package dfs.p332;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem332 {

    static List<String> result = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> item : tickets) {
            String from = item.get(0);
            String to = item.get(1);
            String key = from + to;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        sb.append("JFK");
        backtracking(tickets, "JFK", 0);
        String s = result.get(0);
        for (String temp : result) {
            if(temp.compareTo(s) < 0) {
                s = temp;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            res.add(s.substring(i, i+3));
            i += 3;
        }
        return res;
    }

    void backtracking(List<List<String>> tickets, String start, int times) {
        if(times == tickets.size()) {
            result.add(sb.toString());
            return;
        }
        for (List<String> temp : tickets) {
            String from = temp.get(0);
            String to = temp.get(1);
            String key = from + to;
            int length = sb.length();
            if(start.equals(from) && map.getOrDefault(key, 0) > 0) {
                sb.append(to);
                map.put(key, map.getOrDefault(key, 0) - 1);
                backtracking(tickets, to, times+1);
                sb.delete(length, length + to.length());
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
    }
}
