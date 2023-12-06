package 搜索算法.路径之谜;/*
 *author：yangyu
 *creation time：2023/6/5 22:32
 */

import java.util.Scanner;

public class TheMysteryOfThePath {

    private static int[][] visited;
    private static int[] N, W;
    private static int[][] offset = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int n;

    private static int[] path;

    // 为了终止后面的dfs
    private static boolean end;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        N = new int[n];
        W = new int[n];

        visited = new int[n][n];
        path = new int[n * n];

        for (int i = 0; i < n; i++) {
            N[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            W[i] = in.nextInt();
        }
        in.close();

        dfs(0, 0, 0);

    }

    private static void dfs(int x, int y, int step) {

        //标记为已经走过
        visited[x][y] = 1;
        //记录路径
        path[step] = y * n + x;
        //拔掉对应的箭
        N[x]--;
        W[y]--;

        //判断是否到达终点
        if (x == n - 1 && y == n - 1 && check()) {
            end = true;
            for (int i = 0; i <= step; i++) {
                System.out.print(path[i] + " ");
            }
            return;
        }

        for (int[] position : offset) {
            int a = x + position[0];
            int b = y + position[1];

            //如果没有到达终点，则走下一步
            if (!end && (a >= 0 && a <= n - 1) && (b >= 0 && b <= n - 1) && visited[a][b] == 0) {
                //该点对应箭靶上有箭，说明该点可以走
                if (N[a] > 0 && W[b] > 0) {
                    dfs(a, b, step + 1);
                    //回溯
                    visited[a][b] = 0;
                    N[a]++;
                    W[b]++;
                }
            }
        }

    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            if (N[i] != 0 || W[i] != 0)
                return false;
        }
        return true;
    }
}
