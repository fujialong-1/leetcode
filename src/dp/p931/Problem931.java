package dp.p931;

public class Problem931 {

    public static void main(String[] args) {

        int[][] target = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        System.out.println(minFallingPathSum(target));




    }

    public static int minFallingPathSum(int[][] matrix) {
        // 二维数组的写法
        /*int row = matrix.length;
        int col = matrix[0].length;
        int res = Integer.MAX_VALUE;
        // dp[i][j]表示从下往上走的路径最小值
        int[][] dp = new int[row][col];

        // 初始化dp数组
        for (int i = 0; i < col; i++) {
            dp[row-1][i] = matrix[row-1][i];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + matrix[i][j];
                } else if (j == col-1) {
                    dp[i][j] = Math.min(dp[i+1][j-1], dp[i+1][j]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i+1][j-1], dp[i+1][j]), dp[i+1][j+1]) + matrix[i][j];
                }
            }
        }
        for (int i = 0; i < col; i++) {
            if (dp[0][i] < res) {
                res = dp[0][i];
            }
        }
        return res;*/
        // 降维
        int col = matrix[0].length;
        int row = matrix.length;
        // 定义dp数组
        int[] dp = new int[col];
        // 初始化
        for (int i = 0; i < col; i++) {
            dp[i] = matrix[row-1][i];
        }
        for (int i = row-2; i >= 0; i--) {
            int pre = 0;
            for (int j = 0; j < col; j++) {
                int temp = dp[j];
                if (j == 0) {
                    dp[j] = Math.min(dp[j], dp[j+1]) + matrix[i][j];
                } else if (j == col-1) {
                    dp[j] = Math.min(dp[j], pre) + matrix[i][j];
                } else {
                    dp[j] = Math.min(Math.min(dp[j], pre), dp[j+1]) + matrix[i][j];

                }
                pre = temp;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            if (dp[i] < res) {
                res = dp[i];
            }
        }
        return res;
    }
}
