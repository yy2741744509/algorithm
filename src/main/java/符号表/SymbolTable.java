package 符号表;/*
 *作者：yangyu
 *创建时间：2022/10/2 15:35
 */

public class SymbolTable <Key, Value>{
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

    public SymbolTable() {
        this.head=new Node(null,null,null);
        this.N=0;
    }

    //获取符号表中键值对的个数
    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key, Value value){
        //符号表中已经存在键为key的键值对，那么只需要找到该结点，替换值为value即可
        Node n=head;
        while (n.next != null){
            n=n.next;

            if (n.key.equals(key)){
                n.value=value;
                return;
            }
        }
        //符号表中不存在键为key的键值对，只需创建新结点保存键值对，把新结点插入到链表的头部，head.next=新结点
        Node newNode = new Node(key, value, null);

        newNode.next=head.next;
        head.next=newNode;

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
