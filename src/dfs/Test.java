package dfs;

public class Test {

    // 目标的坐标，暂时设置为右下角
    private static int goal_x = 0;
    private static int goal_y = 0;

    // 地图的宽高，设置为10 * 10的表格
    private static int n = 10;
    private static int m = 10;

    //通过px 和 py数组来实现左下右上的移动顺序
    private static int[] px = new int[]{-1, 0, 1, 0};
    private static int[] py = new int[]{0, -1, 0, 1};

    // 是否能达到终点的标志
    private static boolean flag = false;

    public static void main(String[] args) {

        int[][] graph = new int[n][m];
        int[][] used = new int[n][m];

        dfs(graph, used, 9, 9);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(used[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void dfs(int[][] graph, int[][] used, int x, int y) {
        // 如果与目标坐标相同，则成功
        if (x == goal_x && y == goal_y) {
            System.out.println("successful");
            flag = true;
            return;
        }
        // 遍历四个方向
        for (int i = 0; i < 4; i++) {
            // 如果没有走过这个格子
            int new_x = x + px[i];
            int new_y = y + py[i];
            if (new_x >= 0 && new_x < n && new_y >= 0
                    && new_y < m && used[new_x][new_y] == 0 && !flag) {
                // 将该格子设为走过
                used[new_x][new_y] = 1;
                // 递归下去
                dfs(graph, used, new_x, new_y);
                // 状态回溯，退回来，将格子设置为未走过
                // used[new_x][new_y] = 0;
            }
        }
    }
}
