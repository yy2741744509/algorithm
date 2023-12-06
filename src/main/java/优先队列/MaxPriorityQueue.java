package 优先队列;

public class MaxPriorityQueue<T extends Comparable<T>> {
	//存储元素的数组
	private T[] datas;
	//记录堆中元素的个数
	private int N;
	
	//创建容量为capacity的MaxPriorityQueue对象
	public MaxPriorityQueue(int capacity) {
		this.datas = (T[]) new Comparable[capacity+1];
		this.N = 0;
	}
	
	//判断堆中索引i处的元素是否小于索引j处的元素
	private boolean less(int i, int j) {
		return datas[i].compareTo( datas[j] )<0;
	}
	
	//交换堆中i索引和j索引的值
	private void exch(int i, int j) {
		T temp =datas[i];
		datas[i] = datas[j];
		datas[j] = temp;
	}
	
	//删除队列中最大的元素，并返回这个最大元素
	public T delMax() {
		T max = datas[1];
		exch(1,N);
		datas[N] = null;
		N--;
		sink(1);
		
		return max;
	}
	
	//往队列中插入一个元素
	public void insert(T t) {
		datas[++N] = t;
		swim(N);
	}
	
	//使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
	private void swim(int k) {
		while( k > 1 ) {
			if( less(k/2, k) ) {
				exch(k/2, k);
			}
			k = k/2;
		}
	}
	
	//使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
	private void sink(int k) {
			while( 2*k <=N) {
				int maxIndex=0;
				if( 2*k+1 <=N) {
					maxIndex = less(2*k, 2*k+1) ? 2*k+1 : 2*k;
				}else {
					maxIndex = 2*k;
				}
				
				if( !less(k, maxIndex)) {
					break;
				}
				
				exch(k, maxIndex);
				k = maxIndex;
			}
	}
	
	//获取队列中元素的个数
	public int size() {
		return N;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return N == 0;
	}
}
