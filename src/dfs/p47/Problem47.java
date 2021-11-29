package dfs.p47;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 */
public class Problem47 {

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, path);
        return res;
    }

    void dfs(int[] nums, int index, LinkedList<Integer> path) {
        if(path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, i+1, path);
            path.removeLast();
            visited[i] = false;
        }
    }

}
