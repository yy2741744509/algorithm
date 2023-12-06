package 栈;/*
 *作者：yangyu
 *创建时间：2022/9/20 19:07
 */

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;

    private class Node{
        T data;
        Node next;

        public Node(T data, Node next){
            this.data=data;
            this.next=next;
        }
    }

    public Stack() {
        this.head=new Node(null,null);
        this.N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    //把t元素压入栈
    public void push(T t){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        //创建新结点
        Node newNode = new Node(t, null);
        //让首结点指向新结点
        head.next=newNode;
        //让新结点指向原来的第一个结点
        newNode.next=oldFirst;
        //元素个数+1
        N++;
    }

    //弹出栈顶元素
    public T pop(){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        //让首结点指向原来第一个结点的下一个结点
        if (oldFirst==null){
            return null;
        }
        head.next=oldFirst.next;
        //元素个数-1
        N--;
        return  oldFirst.data;
    }

    //查看栈顶元素
    public T peek(){
        return head.next.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private Node n;
        public SIterator() {
            this.n = head;
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
