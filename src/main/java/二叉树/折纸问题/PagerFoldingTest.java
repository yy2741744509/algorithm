package 二叉树.折纸问题;

import 队列.Queue;

public class PagerFoldingTest {

	public static void main(String[] args) {
	
			Node<String> tree=createTree(20);
			printTree(tree);
		
	}
	
	
	//通过模拟对折多次产生树
	public static Node<String> createTree(int N) {
		//定义根结点
		Node<String> root=new Node<String>("doen",null,null);
		
		for(int i=1; i<N; i++) {
			
			//当前不是第一次对折
			//定义一个辅助队列，通过层序遍历的思想，找到叶子结点，叶子结点添加子结点
			Queue<Node> queue=new Queue();
			queue.enqueue(root);
			
			//循环遍历队列
			while(!queue.isEmpty()) {
				//从队列中弹出一个结点
				Node<String> temp=queue.dequeue();
				
				//如果有左子结点，则把左子结点放入到队列中
				if(temp.left != null) {
					queue.enqueue(temp.left);
				}
				
				//如果有右子结点，则把右子结点放入到队列中
				if(temp.right != null) {
					queue.enqueue(temp.right);
				}
				
				//如果同时没有左右子结点，就是叶子结点，只需给该结点添加左右子结点
				if(temp.right == null && temp.left == null) {
					temp.left=new Node<String>("down",null,null);
					temp.right=new Node<String>("up",null,null);
				}
			
			}
		}
		return root;
	}
	
	
	//打印树中每个结点
	public static void printTree(Node<String> root) {
		//使用中序遍历
		if(root == null)
			return;
		
		if(root.left != null) {
			printTree(root.left);
		}
		
		//打印
		System.out.print(root.data+" ");
		
		if(root.right != null) {
			printTree(root.right);
		}
	}
		
	
	private static class Node<T>{
		public T data;
		public Node left;
		public Node right;
		
		public Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
}
