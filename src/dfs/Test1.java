package dfs;

// 有一个长为N,宽为M的花园，在一次下雨后，花园里面出现了许多水洼，
// 水洼的形状如图所示（0代表土地，1代表水洼，8个方向的水洼都视为联通，属于同一个）：


public class Test1 {
    public static void main(String[] args) {

        int[][] graph = new int[][]{
                {0,0,0,0,0,0,0},
                {0,1,0,0,1,0,0},
                {1,0,0,0,1,1,1},
                {1,0,0,0,0,1,0},
                {1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0},
        };
        System.out.println(seekSolv(graph, 6, 7));
    }


    public static int seekSolv(int[][] grahp, int row, int col) {
        int dfs_time = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grahp[i][j] == 1) {
                    dfs(grahp, row, col, i, j);
                    dfs_time++;
                }
            }
        }
        return dfs_time;
    }

    public static void dfs(int[][] graph, int max_row, int max_col, int row, int col) {
        // 当前节点是水洼1，将其修改为土地0。
        graph[row][col] = 0;
        // 探寻8个方向，是否有水洼
        for (int row_shift = -1; row_shift < 2; row_shift++) {
            for (int col_shift = -1; col_shift < 2; col_shift++) {
                int new_row = row + row_shift;
                int new_col = col + col_shift;
                // 没有越界且为水洼
                if(new_row >= 0 && new_row < max_row && new_col >= 0
                        && new_col < max_col && graph[new_row][new_col] == 1) {
                    dfs(graph , max_row , max_col , new_row , new_col);
                }
            }
        }
    }
}
