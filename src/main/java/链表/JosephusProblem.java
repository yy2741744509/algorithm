package 链表;/*
 *作者：yangyu
 *创建时间：2022/9/20 17:42
 */

public class JosephusProblem {
    public static void main(String[] args) {
        //解决约瑟夫问题

        //1.构建循环链表，包含41个结点，分别存储1~41之间的值
        Node<Integer> first=null;
        Node<Integer> prev=null;

        for (int i = 1; i <= 41; i++) {
            //如果是点一个结点
            if (i==1){
                first=new Node<>(i,null);
                prev=first;
                continue;
            }

            Node<Integer> newNode=new Node(i,null);
            prev.next=newNode;//让上一个结点的next指向新结点
            prev=newNode;//让新结点成为上一个结点;

            //让最后一个结点的next指向first,就变成循环链表了
            if (i==41){
                prev.next=first;
            }
        }

        //2.count计数器模拟报数
        int count=0;

        //3.遍历循环链表
        //记录每次遍历拿到的结点，默认从首结点开始
        Node<Integer> n=first;
        //记录当前节点的上一个结点
        Node<Integer> before=null;
        while (n != n.next){
            //模拟报数
            count++;
            //判断当前报数是不是3
            if (count==3){
                //如果是3，则把当前结点删除，打印当前结点,重置count=0，让当前结点往后移一位
                before.next=n.next;
                System.out.print(n.data+"，");
                count=0;
                n=n.next;
            }else {
                //如果不是3，让before变成当前结点，让当前结点往后移
                before=n;
                n=n.next;
            }
        }
        //打印最后一个结点
        System.out.print(n.data);

    }

    private static class Node<T>{
        T data;
        Node next;

        public Node(T data, Node next){
            this.data=data;
            this.next=next;
        }
    }
}
