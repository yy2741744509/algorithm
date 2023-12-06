package 排序;

import 排序.堆排序.HeapSort;

import java.util.Arrays;

public class HeapSortTest {

	public static void main(String[] args) {
		String[] arr = {"S","O","R","T","E","X","A","M","P","L","E","B","Z","b","a"};
		HeapSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
