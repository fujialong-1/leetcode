package dfs.p463;


// 求岛屿的周长
public class Problem463 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
        };
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    result = dfs(grid, i, j);
                }
            }
        }
        System.out.println(result);
    }

    // 基本的 DFS 框架：每次搜索四个相邻方格
    /*void dfs(int[][] grid, int r, int c) {
        dfs(grid, r - 1, c); // 上边相邻
        dfs(grid, r + 1, c); // 下边相邻
        dfs(grid, r, c - 1); // 左边相邻
        dfs(grid, r, c + 1); // 右边相邻
    }*/

    // 处理方格位于网格边缘的情况
    /*void dfs(int[][] grid, int r, int c) {
        // 若坐标不合法，直接返回
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return;
        }
        // 若该方格不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }*/

    // 标记已遍历过的岛屿，不做重复遍历
    /*void dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return;
        }
        // 已遍历过（值为2）的岛屿在这里会直接返回，不会重复遍历
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2; // 将方格标记为"已遍历"
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }*/

    public static int dfs(int[][] grid, int r, int c) {
        // 从一个岛屿方格走向网格边界，周长加 1
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        // 从一个岛屿方格走向水域方格，周长加 1
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }









}
