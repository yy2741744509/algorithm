package 排序.选择排序;/*
 *作者：yangyu
 *创建时间：2022/10/26 21:50
 */

public class Selection {
    public static void sort(Comparable[] arr){
        for (int i=0; i<arr.length-1; i++){
            int minIndex = i;
            for (int j=i+1; j< arr.length; j++){
                // 比较大小，如果arr[minIndex] > arr[j] ，就使minIndex = j
                if (greater(arr[minIndex],arr[j])){
                    minIndex = j;
                }
            }
            exch(arr,i,minIndex);
        }
    }

    /**
     * 比较器
     */
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     *交换器
     */
    public static void exch(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
