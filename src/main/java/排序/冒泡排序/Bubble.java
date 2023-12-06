package 排序.冒泡排序;/*
 *作者：yangyu
 *创建时间：2022/10/26 21:50
 */

public class Bubble {
    public static void sort(Comparable[] arr){
        for (int i= arr.length-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (greater(arr[j], arr[j+1])){
                    exch(arr,j,j+1);
                }
            }
        }
    }

    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }

    public static void exch(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
