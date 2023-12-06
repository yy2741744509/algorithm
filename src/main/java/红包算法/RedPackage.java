package 红包算法;

public class RedPackage {
    public static void main(String[] args) {
        robRedPackage(0.03, 2);
    }

    private static void robRedPackage(double money, int n) {
        double sum = 0;
        for (int i = n; i > 0; i--) {

            double avg = Math.floor((money / i) * 100) / 100;
            double amount;

            if (i == 1) {
                amount = money;
                money -= money;
            } else {
                amount = Math.floor((Math.random() * (avg * 2 - 0.01) + 0.01) * 100) / 100;

                if (amount == 0.0) {
                    amount = 0.01;
                }

                money -= amount;
                money = Math.round(money * 100) / 100.0;
            }
            System.out.println(amount);
            sum += amount;
        }
        System.out.println("总共：" + Math.round(sum * 100) / 100.0);
    }
}
