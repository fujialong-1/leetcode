package dfs.p89;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem89 {



    public static void main(String[] args) {

    }

    List<Integer> res = new ArrayList();
    boolean[] visited;
    public List<Integer> grayCode(int n) {
        visited = new boolean[1<<n];
        dfs(0, n);
        return res;
    }

    // 对于这种找到一个正确结果就返回的函数，返回类型定为了boolean
    boolean dfs(int cur, int n){
        if(res.size() == (1<<n))
            return true;
        res.add(cur);
        visited[cur]=true;
        for(int i = 0; i < n; i++){
            //这里改变cur的某一位，用异或
            int next = cur ^ (1<<i);
            if(!visited[next] && dfs(next,n))
                return true;
        }
        visited[cur] = false;
        return false;
    }
}
