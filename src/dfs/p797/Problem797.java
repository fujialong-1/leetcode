package dfs.p797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem797 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> lst = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0);
        return res;
    }

    public void dfs(int[][] graph,int i){
        if(i==graph.length-1){
            lst.add(i);
            res.add(new LinkedList<>(lst));
            lst.remove(lst.size()-1);
            return;
        }
        lst.add(i);
        for(int j:graph[i]){
            dfs(graph,j);
        }
        lst.remove(lst.size()-1);
    }
}
