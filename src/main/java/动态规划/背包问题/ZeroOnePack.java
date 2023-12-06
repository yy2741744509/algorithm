package 动态规划.背包问题;/*
 *author：yangyu
 *creation time：2023/6/1 22:17
 */

import java.util.Arrays;

public class ZeroOnePack {
    public static void main(String[] args) {
        int V = 8;
        int N = 4;
        int[] weight = new int[]{0, 2, 3, 4, 5};
        int[] value = new int[]{0, 3, 4, 5, 6};

        System.out.println("背包容量：" + V);
        System.out.println("物品数量：" + N);
        System.out.println("物品容量：" + Arrays.toString(weight));
        System.out.println("物品价值：" + Arrays.toString(value));

        getArticles(V, N, weight, value);
    }

    /**
     * 求解01背包问题
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    private static int[][] zeroOnePack(int V, int N, int[] weight, int[] value) {
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                //由于weight和value数组下标都是从 1 开始,故注意第i个物品的重量为weight[i],价值为value[i]
                //如果第i件物品的重量大于背包容量j,则第i件物品不装入背包，存放前i-1个物品的价值
                if (weight[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);

            }
        }

        return dp;
    }

    /**
     * 已知价值最大，求背包内装入了哪些物品？
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    private static void getArticles(int V, int N, int[] weight, int[] value) {
        int[][] dp = zeroOnePack(V, N, weight, value);

        System.out.println("动态规划表如下：");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("背包内最大的物品价值总和为：" + dp[N][V]);

        boolean[] flags = new boolean[N + 1];

        for (int i = N; i > 0; i--) {
            //如果dp[i][j] == dp[i-1][j]，则说明第i个物品没有放入dp[i][j]中，否则反之
            if (dp[i][V] > dp[i - 1][V]) {
                flags[i] = true;
                //放入物品后背包容量减少
                V -= weight[i];
            }

        }

        System.out.print("包内物品的编号为：");
        for (int i = 1; i <= N; i++) {
            if (flags[i]) {
                System.out.print(i + " ");
            }
        }

    }
}
