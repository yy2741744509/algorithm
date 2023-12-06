package 队列;/*
 *作者：yangyu
 *创建时间：2022/9/27 19:05
 */

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node head;
    private Node last;
    private int N;

    private class Node{
        public T data;
        public Node next;

        public Node(T data, Node next){
            this.data=data;
            this.next=next;
        }
    }

    public Queue(){
        this.head=new Node(null, null);
        this.last=null;
        this.N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void enqueue(T t){
        if (last==null){
            last=new Node(t,null);
            head.next=last;
        }else {
            Node oldLast=last;
            last=new Node(t, null);
            oldLast.next=last;
        }
        N++;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }

        Node oldLast=head.next;
        head.next=oldLast.next;
        N--;

        if (isEmpty()){
            last=null;
        }
        return oldLast.data;
    }


    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    public class QIterator implements Iterator{
        private Node n;

        public QIterator() {
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
