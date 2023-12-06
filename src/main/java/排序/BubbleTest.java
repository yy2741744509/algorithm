package 排序;/*
 *作者：yangyu
 *创建时间：2022/10/26 21:55
 */

import 排序.冒泡排序.Bubble;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 7, 3, 6, 4, 2, 1, 9, 5};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
