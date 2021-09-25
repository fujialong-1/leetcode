package bfs.p463;

import java.util.LinkedList;
import java.util.Queue;

public class Problem463 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {

        int[][] test = new int[][]{
                {1, 0}
        };
        System.out.println(islandPerimeter(test));

    }

    public static int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0; // 保存结果
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res += cal(grid, i, j);
                    grid[i][j] = 2; // 将遍历过的陆地置为2
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        for (int k = 0; k < 4; k++) {
                            int mx = x + dx[k], my = y + dy[k];
                            if (mx < 0 || my < 0 || mx >= grid.length || my >= grid[0].length || grid[mx][my] != 1) {
                                continue;
                            }
                            res += cal(grid, mx, my);
                            grid[mx][my] = 2;
                            queue.offer(new int[]{mx, my});
                        }
                    }
                    return res;
                }
            }
        }
        return res;
    }

    public static int cal(int[][] grid, int x, int y) {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i], my = y + dy[i];
            // || grid[mx][my] == 0
            if (mx < 0 || my < 0 || mx >= grid.length || my >= grid[0].length || grid[mx][my] == 0) {
                temp++;
            }
        }
        return temp;
    }

}
