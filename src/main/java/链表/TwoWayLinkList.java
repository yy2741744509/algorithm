package 链表;/*
 *作者：yangyu
 *创建时间：2022/9/17 13:32
 */

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T> {
    private Node head; //首结点
    private Node last;  //记录尾结点
    private int N;      //记录链表的长度

    private class Node<T>{
        T data;     //存储数据
        Node next;  //记录下一个结点
        Node pre;   //记录上一个结点

        public Node(T data, Node pre, Node next) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
    }

    public TwoWayLinkList() {
        //初始化头结点和尾结点
        this.head=new Node(null,null,null);
        this.last=null;
        //初始化元素个数
        this.N=0;
    }

    public void display(){
        for (Node n=head; n.next!=null; n=n.next) {
            System.out.println(n.next.data);
        }
    }

    /**
     * 清空线性表
     */
    public void clear(){
        this.head.next=null;
        this.head.pre=null;
        this.head.data=null;
        this.last=null;
        this.N=0;
    }

    /**
     * 判断线性表是否为空
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 获取线性表中元素的个数
     */
    public int length(){
        return N;
    }

    /**
     * 读取并返回线性表的第i个元素
     */
    public T get(int index){
        //获取i位置的结点
        Node n=head.next;
        for (int i = 0; i < index; i++) {
            n=n.next;
        }
        return (T) n.data;
    }

    /**
     * 往线性表中添加一个元素
     */
    public void insert(T t){

        if (isEmpty()){
            //如果链表为空

            //创建新结点
            Node newNode = new Node(t, head, null);
            //让新结点为尾结点
            last=newNode;
            //让头结点指向尾结点
            head.next=last;
        }else {
            //如果链表不为空

            //创建新的结点
            Node newNode = new Node(t,last,null);
            //让当前的尾结点指向新结点
            last.next=newNode;
            //让新结点成为尾结点
            last=newNode;
        }
        N++;
    }

    /**
     * 在线性表的第i个元素前插入一个值为t的数据元素
     */
    public void insert(int i ,T t){
        //找到位置为i-1的结点
        Node pre=head;
        for (int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到位置为i的结点
        Node curr=pre.next;

        //创建新结点
        Node newNode = new Node(t, pre, curr);
        //令位置为i-1的结点的next变为新结点
        pre.next=newNode;

        //令位置为i的结点的pre变为新结点
        curr.pre=newNode;

        //元素个数加+1
        N++;
    }

    /**
     * 删除并返回线性表的第i个元素
     */
    public T remove(int i){
        //找到位置为i-1的结点
        Node pre=head;
        for (int index = 0; index < i; index++) {
            pre=pre.next;
        }
        //找到位置为i的结点
        Node curr=pre.next;
        //找到位置为i的结点的下一个结点
        Node nextNode=curr.next;
        //让i-1位置的下一个结点指向i位置的结点的下一个结点
        pre.next=nextNode;
        //让i位置的下一个结点的pre指向i位置的上一个结点
        nextNode.pre=pre;
        //元素个数-1
        N--;
        return (T) curr.data;
    }

    /**
     * 返回线性表中首次出现的指定的数据元素的位序号,若不存在。则返回-1
     */
    public int indexOf(T t){
        Node n=head;
        for (int i = 0; n.next!=null; i++) {
            n=n.next;
            if (n.data.equals(t))
                return i;
        }
        return -1;
    }

    /**
     * 获取第一个元素
     */
    public T getFirst(){
        return isEmpty()? null : (T) head.next.data;
    }

    /**
     * 获取最后一个元素
     */
    public T getLast(){
        return isEmpty() ? null : (T) this.last.data;
    }


    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        private Node n;
        public TIterator() {
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.data;
        }
    }


}
