package 红黑树;/*
 *作者：yangyu
 *创建时间：2022/10/18 0:13
 */

import com.sun.org.apache.regexp.internal.RE;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    //记录根结点
    private Node root;
    private int N;
    //红色链接标识
    private static final boolean RED = true;
    //黑色链接标识
    private static final boolean BLACK = false;

    //结点类
    private class Node {
        //记录左子结点
        public Node left;
        //记录右子节点
        public Node right;
        //存储键
        public Key key;
        //存储值
        public Value value;
        //由其父结点指向它的链接的颜色
        public boolean color;

        public Node(Key key, Value value,Node left, Node right, boolean color) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    //判断当前结点的父指向链接是否为红色
    private boolean isRed(Node x){
        if(x == null)
            return false;
        return x.color == RED;
    }

    //左旋调整
    private Node rotateLeft(Node h){
        //获取h结点的右子结点，表示x
        Node x = h.right;
        //让x结点的左子结点成为h结点的右子结点
        h.right = x.left;
        //让h成为x结点的左子结点
        x.left = h;
        //让x结点的color属性 = h结点的color属性
        x.color = h.color;
        //让h结点的color属性=RED
        h.color = RED;

        return x;
    }

    //右旋调整
    private Node rotateRight(Node h){
        //获取h结点的左子结点，表示x
        Node x = h.left;
        //让x结点的右子结点成为h结点的左子结点
        h.left = x.right;
        //让h成为x结点的右子结点
        x.right = h;
        //让x结点的color属性 = h结点的color属性
        x.color = h.color;
        //让h结点的color属性=RED
        h.color = RED;

        return x;
    }

    //颜色反转，相当于完成拆分4-结点
    private void flipColors(Node h){
        //当前结点变为红色
        h.color = RED;
        //左右子结点变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    //在整个树上完成插入操作
    public void put(Key key, Value value){
        root = put(root,key,value);
        //根结点的颜色总是黑色
        root.color = BLACK;
    }

    //在指定树中，完成插入操作，并返回添加元素后的新树
    private Node put(Node h, Key key, Value value){
        //判断h是否为空，如果是，则返回一个红色的结点
        if (h == null){
            //数量加1
            N++;
            return new Node(key,value,null,null,RED);
        }
        //比较h结点的键和key的大小
        int cmp = key.compareTo(h.key);
        if (cmp < 0){
            //继续往左
            h.left = put(h.left,key,value);
        }else if (cmp > 0){
            //继续往右
            h.right = put(h.right,key,value);
        }else {
            //相等就替换值
            h.value = value;
        }

        //进行左旋,如果当前结点h的左子结点为黑色，右子结点为黑色，需要左旋
        if (isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        //进行右旋，如果当前结点h的左子结点和左子结点的左子结点都为红色，需要右旋
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        //颜色反转,当前结点h的左右子结点都为红色是，需要颜色反转
        if (isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }

        return h;
    }

    //根据key，从树中找出对应的值
    public Value get(Key key){
        return get(root,key);
    }

    //从指定的树x中，找出key对应的值
    private Value get(Node x, Key key){
        if (x == null){
            return null;
        }
        //比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);

        if (cmp < 0){
            return get(x.left,key);
        } else if (cmp > 0) {
            return get(x.right,key);
        }else {
            return x.value;
        }

    }

    //获取树中元素的个数
    public int size(){
        return N;
    }
}
