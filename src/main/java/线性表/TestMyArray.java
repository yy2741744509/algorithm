package 线性表;/*
 *作者：yangyu
 *创建时间：2022/9/6 20:44
 */

public class TestMyArray {
    public static void main(String[] args) {
        //创建一个可变的数组
        MyArray array = new MyArray();

        //获取长度
        int length = array.size();
        System.out.println("length:"+length);
        array.display();
        System.out.println("=====================");

        //往可变数组中添加元素
        array.append(99);
        array.append(98);
        array.append(97);
        //显示可变数组中的所有元素到控制台
        array.display();
        System.out.println("=====================");


        //删除某个元素：删除第一个元素
        array.remove(0);
        array.display();
        System.out.println("=====================");

        //取出指定位置的元素
        int element = array.get(1);
        System.out.println("下标为1的元素:"+element);
        System.out.println("=====================");


        //往可变数组中添加元素：往可变数组中添加三个元素（86，85，84）
        array.append(86);
        array.append(85);
        array.append(84);
        array.display();
        System.out.println("=====================");


        //插入元素到指定位置，
        array.insert(3, 33);
        array.display();
        System.out.println("=====================");


        //替换指定位置的元素,用50替换索引为2的位置的元素
        array.set(2,50);
        array.display();
        System.out.println("length"+array.size());
    }

}
