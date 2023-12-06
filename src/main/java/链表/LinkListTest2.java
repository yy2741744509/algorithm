package 链表;/*
 *作者：yangyu
 *创建时间：2022/9/15 21:18
 */

public class LinkListTest2 {
    public static void main(String[] args) {

        LinkList<Student> linkList=new LinkList();
        Student[] students=new Student[5];
        students[0]=new Student("30","杨瑜",100);
        students[1]=new Student("31","张三",99);
        students[2]=new Student("32","李四",98);
        students[3]=new Student("33","王五",97);
        students[4]=new Student("34","赵六",96);
        int l=students.length;
        for (int i = 0; i < l; i++) {
            linkList.append(students[i]);
        }
        linkList.display();

        System.out.println("====================");

        linkList.reverse();

        linkList.display();
    }
}
