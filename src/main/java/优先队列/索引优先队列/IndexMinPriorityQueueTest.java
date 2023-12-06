package 优先队列.索引优先队列;

public class IndexMinPriorityQueueTest {

	public static void main(String[] args) {
		//创建索引最小优先队列
		IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
		
		queue.insert(0, "A");
		queue.insert(1, "C");
		queue.insert(2, "F");
		queue.insert(3, "D");
		queue.insert(4, "Z");
		
		queue.changeItem(2, "B");
		
		while( !queue.isEmpty()) {
			System.out.print(queue.delMin()+" ");
		}
	}

}
