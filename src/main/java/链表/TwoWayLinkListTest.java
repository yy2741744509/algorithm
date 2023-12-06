package 链表;


public class TwoWayLinkListTest {
    public static void main(String[] args) {

        TwoWayLinkList<Student> linkList=new TwoWayLinkList<Student>();
        Student[] students=new Student[5];
        students[0]=new Student("30","杨瑜",100);
        students[1]=new Student("31","张三",99);
        students[2]=new Student("32","李四",98);
        students[3]=new Student("33","王五",97);
        students[4]=new Student("34","赵六",96);
        int l=students.length;
        for (int i = 0; i < l; i++) {
            linkList.insert(students[i]);
        }
        linkList.display();

        System.out.println("下标为0的元素:"+linkList.get(0).toString());

        System.out.println("被删除的元素:"+linkList.remove(0).toString());


        System.out.println("元素的个数为"+linkList.length());

        linkList.insert(new Student("01","徐凤年",60));
        linkList.display();

        System.out.println("============================");
        System.out.println("第一个元素是："+linkList.getFirst());
        System.out.println("最后一个元素是："+linkList.getLast());
    }
}
