package 线性表;/*
 *作者：yangyu
 *创建时间：2022/9/6 20:01
 */

import java.util.Arrays;

public class MyArray implements LinearList {
    //创建存储数据的数组
    private int[] arr;

    //初始化数组
    public MyArray() {
        this.arr = new int[0];
    }

    /**
     * 返回数组长度
     */
    @Override
    public int size() {
        return arr.length;
    }

    /**
     * 在数组末尾添加元素
     */
    @Override
    public void append(int n) {
        //新建一个数组
        int[] newArr = new int[arr.length + 1];

        //把原数组中的元素复制到新数组中
        System.arraycopy(arr, 0, newArr, 0, arr.length);

        //将最后一个元素添加到新数组的末尾
        newArr[newArr.length - 1] = n;

        //使新数组替换旧数组
        arr = newArr;
    }

    /**
     * 打印所有元素到控制台
     */
    @Override
    public void display() {
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 删除数组中的元素
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        //先判断索引是否越界
        if (!(index >= 0 || index <= arr.length - 1))
            throw new ArrayIndexOutOfBoundsException("索引 " + index + " 越界");

        //新建一个数组，长度为原数组的长度-1
        int[] newArr = new int[arr.length - 1];

        //复制原有数据到新数组
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - (index + 1));

        //使新数组替换旧数组
        arr = newArr;
    }

    /**
     * 取出指定位置的元素
     */
    @Override
    public int get(int index) {
        //先判断索引是否越界
        if (!(index >= 0 || index <= arr.length - 1))
            throw new ArrayIndexOutOfBoundsException("索引 " + index + " 越界");

        return arr[index];
    }

    /**
     * 插入一个元素到指定位置
     */
    @Override
    public void insert(int index, int n) {
        //先判断索引是否越界
        if (!(index >= 0 || index <= arr.length - 1))
            throw new ArrayIndexOutOfBoundsException("索引 " + index + " 越界");

        //新建一个数组，长度为原数组的长度+1
        int[] newArr = new int[arr.length + 1];

        // 将原数组中的元素放入新数组中。
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
        newArr[index] = n;

        //使新数组替换旧数组
        arr = newArr;
    }

    @Override
    public void set(int index, int n) {
        //先判断索引是否越界
        if (!(index >= 0 || index <= arr.length - 1))
            throw new ArrayIndexOutOfBoundsException("索引 " + index + " 越界");

        arr[index] = n;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public void clear() {

    }
}
