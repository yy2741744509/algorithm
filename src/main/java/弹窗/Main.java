package 弹窗;/*
 *author：yangyu
 *creation time：2023/9/22 23:06
 */

public class Main {
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 150; i++) {
                new PopupWindow();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            new PopupWindow("等你多久我都愿意");
        }).start();

    }
}
