package 链表;/*
 *作者：yangyu
 *创建时间：2022/9/13 19:02
 */

import java.util.Iterator;

/**
 * 单链表类 实现顺序表接口
 */
public class LinkList<T> implements Iterable{
    private Node head;   //单链表的头指针指向头结点
    private int N;   //链表的长度

    //成员内部类 结点类
    private class Node{
        T data; //数据域
        Node next;  //下一个结点

        public Node(T data,Node next){
            this.data=data;
            this.next=next;
        }
    }

    public LinkList(){
        //初始化头结点
        this.head=new Node(null,null);
        //初始化元素个数
        this.N=0;
    }

    //清空链表
    public void clear(){
        N=0;
        head.next=null;
    }
    //获取链表的长度
    public int size() {
        return N;
    }
    //获取指定位置i的元素
    public T get(int index) {
        if (index>this.N-1)
            throw new ArrayIndexOutOfBoundsException("下标越界");

        Node n=head.next;
        for (int i=0;i<index;i++){
            n=n.next;
        }
        return n.data;
    }
    //向指定位置i处添加元素
    public void insert(int i, T t) {
        //找到i位置的前一个结点
        Node pre=head;
        for (int index=0; index<i; index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node current=pre.next;
        //创建新结点，并且新结点要指向原来i位置的结点
        Node newNode = new Node(t, current);
        //原来i位置的前一个结点指向新结点即可
        pre.next=newNode;
        //元素个数+1
        N++;
    }
    public void append(T t) {
        Node n=head;
        while (n.next != null){
            n=n.next;
        }
        Node newNode=new Node(t,null);

        n.next=newNode; //令最后一个结点指向新的结点

        N++;    //长度+1
    }


    public void display() {
        Node n=head;
        while (n.next != null){
            n=n.next;
            System.out.println(n.data);
        }

    }

    //删除i出指定的元素，并返回被删除的元素
    public T remove(int i) {
        //找到i位置的前一个结点
        Node pre=head;
        for (int index=0; index<i; index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node current=pre.next;
        //找到i位置的下一个结点
        Node nextNode=current.next;
        //令i位置的前一个结点指向i位置的后一个结点
        pre.next=nextNode;
        //元素-1
        N--;
        return current.data;
    }

    public int indexOf(T t){
        //从头结点开始，依次找到每一个结点，取出数据和t比较，如果相同就找到了
        Node n=head;
        for (int i=0;n.next!=null;i++){
            n=n.next;
            if (n.data.equals(t))
                return i;
        }
        return -1;
    }



    public void set(int index, T t) {
        if (index>this.N-1)
            throw new ArrayIndexOutOfBoundsException("下标越界");

        Node n=head;
        for (int i=0;i<=index;i++){
            n=n.next;
        }

            n.data=t;
    }


    public boolean contains(T key) {
        Node p=this.head.next;
        for (;p != null;p=p.next){
            if (p.data.equals(key))
                return true;
        }
        return false;
    }

    public void addFirst(T data){
        Node newNode=new Node(data,head.next);
        head.next=newNode;
    }

    public boolean isEmpty(){
        return this.head.next == null;
    }

    /**
     * 反转链表
     * @return
     */
    public void reverse(){
        if (isEmpty())
            return;
        reverse(head.next);
    }

    public Node reverse(Node curr){ //假设head--->A  n--->B  n--->C  n--->D  n--->null
        if (curr.next==null) {
            head.next = curr;
            return curr;
        }
        Node pre=reverse(curr.next);//pre最后一个元素

        pre.next=curr; //curr就是pre的下一个元素，也就是原链表pre的上一个元素

        curr.next=null;

        return curr;//返回C，以此类推
    }


    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;

        public LIterator(){
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
