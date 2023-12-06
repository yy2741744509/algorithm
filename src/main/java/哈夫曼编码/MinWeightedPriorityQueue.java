package 哈夫曼编码;

public class MinWeightedPriorityQueue {
	//存储元素的数组
	private Node[] datas;
	//记录堆中元素的个数
	private int N;


	//创建容量为capacity的MinPriorityQueue对象
	public MinWeightedPriorityQueue(int capacity) {
		this.datas =  new Node[capacity+1];
		for (int i = 1; i < datas.length; i++) {
			datas[i] =  new Node(null,null,null,null);
		}
		this.N = 0;
	}
	
	//判断堆中索引i处的元素是否小于索引j处的元素
	private boolean less(int i, int j) {
		return datas[i].getValue() - datas[j].getValue() <0;
	}
	
	//交换堆中i索引和j索引的值
	private void exch(int i, int j) {
		Node temp =datas[i];
		datas[i] = datas[j];
		datas[j] = temp;
	}
	
	//删除队列中最大的元素，并返回这个最大元素
	public Node delMin() {
		Node min = datas[1];
		exch(1,N);
		datas[N] = null;
		N--;
		sink(1);
		
		return min;
	}
	
	//往队列中插入一个元素
	public void insert(Node t) {
		datas[++N] = t;
		swim(N);
	}
	
	//使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
	private void swim(int k) {
		while( k > 1 ) {
			if( less(k, k/2) ) {
				exch(k/2, k);
			}
			k = k/2;
		}
	}
	
	//使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
	private void sink(int k) {
			while( 2*k <=N) {
				int minIndex=0;
				if( 2*k+1 <=N) {
					minIndex = less(2*k, 2*k+1) ? 2*k : 2*k+1;
				}else {
					minIndex = 2*k;
				}
				
				if( !less(minIndex, k)) {
					break;
				}
				
				exch(k, minIndex);
				k = minIndex;
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
