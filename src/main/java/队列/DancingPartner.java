package 队列;/*
 *作者：yangyu
 *创建时间：2022/9/27 19:35
 */

public class DancingPartner {
    public static void main(String[] args) {
        Queue<Dancer> Q1 = new Queue<>();
        Queue<Dancer> Q2 = new Queue<>();

        for (int i=1; i<=6; i++){
            //男舞伴
            Q1.enqueue(new Dancer("gentlemen" + i, "man"));

            //女舞伴
            if (i<=3)
                Q2.enqueue(new Dancer("lady" + i, "woman"));
        }
        //测试
        match(Q1,Q2,6);
    }

    public static void match(Queue<Dancer> Q1, Queue<Dancer> Q2, int round){

        //如果两个队列都不为空
        while (!Q1.isEmpty() && !Q2.isEmpty()){
            //男舞伴出列
            Dancer male = Q1.dequeue();
            //女舞伴出列
            Dancer female = Q2.dequeue();

            System.out.printf("%s======%s\n",female,male);

            //跳完进入队列
            Q2.enqueue(female);
            Q1.enqueue(male);

            if (--round == 0) break;
        }
    }

    //内部舞伴类
    private static class Dancer {
        //姓名
        public String name;
        //性别
        public String gender;

        public Dancer(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Dancer{" +
                    "姓名='" + name + '\'' +
                    ", 性别='" + gender + '\'' +
                    '}';
        }
    }
}
