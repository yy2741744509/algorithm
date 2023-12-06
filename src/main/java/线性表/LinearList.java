package 线性表;/*
 *作者：yangyu
 *创建时间：2022/9/6 19:51
 */

public interface LinearList<T> {
    //（2）编写获取数组长度的方法
    int size();

    //（3）编写往数组的末尾添加一个元素的方法
    void append(int n);

    //（4）编写打印所有元素到控制台的方法
    void display();

    //（5）编写删除数组中的元素的方法
    void remove(int index);

    //（6）编写取出指定位置的元素的方法
    int get(int index);

    //（7）编写插入一个元素到指定位置的方法
    void insert(int index, int n);

    //（8）编写替换指定位置的元素的方法
    void set(int index, int n);

    boolean isEmpty();

    boolean contains(int key);

    void clear();

}
