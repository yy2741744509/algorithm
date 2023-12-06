package 排序.直接插入排序;/*
 *author：yangyu
 *creation time：2022/12/6 19:17
 */

import java.util.Arrays;

public class DirectInsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{32,65,97,76,13,27,18,57};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            for (int j = i-1; j >= 0; j--) {
                if (arr[j] > temp){
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
