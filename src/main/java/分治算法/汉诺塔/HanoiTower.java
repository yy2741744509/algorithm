package 分治算法.汉诺塔;/*
 *author：yangyu
 *creation time：2023/6/1 19:13
 */

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(2, 'a', 'b', 'c');
    }

    private static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1)
            System.out.println("第1个盘从 " + a + "->" + c);
        else {
            //  1. 先将最上面所有的盘从 A -> B
            hanoiTower(num - 1, a, c, b);

            //  2. 将最下面的盘从 A -> C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);

            //  3. 把B塔上的所有盘从 B -> C
            hanoiTower(num - 1, b, a, c);
        }
    }
}
