package 优先队列;

public class MinPriorityQueueTest {

	public static void main(String[] args) {
		//创建优先队列
		MinPriorityQueue<String> queue = new MinPriorityQueue<String>(10);
		//往队列中存储元素
		queue.insert("B");
		queue.insert("D");
		queue.insert("G");
		queue.insert("E");
		queue.insert("C");
		queue.insert("F");
		queue.insert("A");
		
		//通过循环从队列中获取最大的元素
		while( !queue.isEmpty() ) {
			System.out.print(queue.delMin() +" ");
		}
	}

}
