package 动态规划.背包问题.火柴棒数字;/*
 *author：yangyu
 *creation time：2023/6/4 12:20
 */


public class Main {

    static int V = 300;
    static int N = 10;
    static int[] W = {0, 6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public static void main(String[] args) {

        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                for (int k = 0; k <= 10; k++) {
                    if (k * W[i] <= j)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * W[i]] + k);
                }
            }
        }

        for (int i = 10, k = 0; i > 0; i--) {
            for (int g = 1; g <= 10; g++) {
                if (V >= g * W[i] && dp[i][V] == dp[i - 1][V - g * W[i]] + g)
                    k = g;
            }
            for (V -= k * W[i]; k > 0; --k)
                System.out.print(i - 1);
        }


    }
}

