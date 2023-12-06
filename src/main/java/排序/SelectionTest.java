package 排序;/*
 *作者：yangyu
 *创建时间：2022/10/26 21:55
 */


import 排序.选择排序.Selection;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 7, 3, 6, 4, 2, 1, 9, 5};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("========测试========");
        System.out.println(Selection.greater('a', 'b'));
        System.out.println(Selection.greater(1, 2));
        System.out.println(Selection.greater("a", "b"));
        System.out.println(Selection.greater("abc", "abcd"));
        System.out.println(Selection.greater(10, 1));
    }
}
