package 排序.快速排序;/*
 *author：yangyu
 *creation time：2022/12/13 21:25
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {33, 11, 5, 6, 12, 67, 45, 54, 88, 99};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pivot = arr[low];
        int left = low;
        int right = high;

        while (left < right) {

            while (left < right && pivot <= arr[right]) right--;
            arr[left] = arr[right];

            while (left < right && pivot >= arr[left]) left++;
            arr[right] = arr[left];
        }

        arr[left] = pivot;
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }
}
