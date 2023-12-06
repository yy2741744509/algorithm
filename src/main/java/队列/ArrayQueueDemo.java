package 队列;/*
 *作者：yangyu
 *创建时间：2022/8/27 9:09
 */

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

//使用数组模拟队列，
class ArrayQueue{
    private int maxSize;    //表示数组最大容量
    private int front;      //队列头
    private int rear;       //队列尾
    private int[] arr;      //存放数据，模拟队列

    //创建队列构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr=new int[maxSize];
        front=-1;   //指向队列头部,分析出front是指向队列头的前一个位置
        rear=-1;    //指向队列尾部,指向队列尾的数据(即就是队列最后一个数据)
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        arr[++rear]=n;
    }

    //获取队列数据，出队列
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[++front];
    }

    //显示队列的所有数据
    public void shoeQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空的，没有数据~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头部数据，注意不是取出数据
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据~");
        }
        return arr[front+1];
    }
}