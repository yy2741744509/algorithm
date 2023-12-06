import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        int[][] point = new int[n][2];
        for (int i = 0; i < n; i++) {
            point[i][0] = scanner.nextInt();
            point[i][1] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= h; j++) {
                for (int p = 0; p < point.length; p++) {
                    if (calculate(i, j, point[p][0], point[p][1], r)) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    }

    static boolean calculate(int x, int y, int pointX, int pointY, int r) {
        double d = Math.sqrt(Math.pow(x-pointX, 2) + Math.pow(y-pointY, 2));
        if (d <= r) {
            return true;
        }
        return false;
    }

}
