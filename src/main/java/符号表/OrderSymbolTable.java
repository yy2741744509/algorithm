package 符号表;/*
 *作者：yangyu
 *创建时间：2022/10/2 15:35
 */

public class OrderSymbolTable<Key extends Comparable<Key>, Value>{
    //记录首结点
    private Node head;
    //记录符号表中记录的元素个数
    private int N;

    private class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.head=new Node(null,null,null);
        this.N=0;
    }

    //获取符号表中键值对的个数
    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key, Value value){
        //定义两个Node变量，分别记录当前结点和当前结点的上一个结点
        Node curr=head.next;
        Node pre=head;
        while (curr != null && key.compareTo(curr.key)>0){

            //变换当前结点和前一个结点
            pre=curr;
            curr=curr.next;
        }

        //如果当前结点的键和要插入的key一样，则替换
        if (curr != null && key.compareTo(curr.key)==0){
            curr.value=value;
            return;
        }

        //如果不一样，把新的结点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next=newNode;

        N++;
    }

    //删除符号表中键为key的键值对
    public void delete(Key key){
        Node n=head;
        while (n.next != null){
            n=n.next;

            if (n.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
        }
    }

    //从符号表中获取key对应的值
    public Value get(Key key){
        Node n=head;
        while (n.next != null){
            n=n.next;
            if (n.key.equals(key)){
                return n.value;
            }
        }

        return null;
    }
}
