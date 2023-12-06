package 二叉树;/*
 *作者：yangyu
 *创建时间：2022/10/11 14:22
 */


import 队列.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    //记录根节点
    private Node root;
    //记录树中元素的个数
    private int N;

    private class Node{
        //存储键
        public Key key;
        //存储值
        public Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public BinaryTree() {
    }

    //向树中插入一个键值对
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    //给指定树x上，添加一个键值对，并返回添加后的新树
    private Node put(Node x,Key key,Value value){
        //如果x子树为null
        if (x == null){
            N++;
            return new Node(key,value,null,null);
        }

        //如果子树x!=null
        //比较x结点的 键 和 key 的大小：左<根<右
        int cmp=key.compareTo(x.key);
        if (cmp>0){
            x.right = put(x.right,key,value);
        }else if (cmp<0){
            x.left = put(x.left,key,value);
        }else {
            //如果key等于x结点的键，则令x结点的值=value
            x.value=value;
        }
        return x;
    }

    //根据key，从树中找出对应的值
    public Value get(Key key){
        return get(root,key);
    }

    //从指定树x中，找出key对应的值
    private Value get(Node x,Key key){
        //x树为null
        if (x == null){
            return null;
        }

        //x树不为null
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            //如果key>x.key，则继续找x结点的右子树
            return get(x.right,key);
        }else if (cmp<0){
            //如果key<x.key，则继续找x结点的左子树
            return get(x.left,key);
        }
        //如果key=x.key，就找到了键为key的结点，只需返回x.value
        return x.value;
    }

    //删除树中对应的键值对
    public void delete(Key key){
        delete(root,key);
    }

    //删除指定树x上键为key的键值对，并返回删除后的新树
    private Node delete(Node x,Key key){
        //x==null
        if (x==null){
            return null;
        }

        //x!=null
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            //如果key>x.key，则继续找x结点的右子树
            x.right = delete(x.right,key);
        }else if (cmp<0){
            //如果key<x.key，则继续找x结点的左子树
            x.left = delete(x.left,key);
        }else {
            //如果key=x.key，就完成删除结点动作
            N--;
            
            //如果是根结点
            if (x.right == null && x== root){
            	root=x.left;
                return x;
            }
            if (x.left == null && x== root){
            	root=x.right;
                return x;
            }
            
            //首先的找到右子树中最小的结点
            if (x.right == null){
                return x.left;
            }
            if (x.left == null){
                return x.right;
            }

            Node n=x.right;
            Node minNode=min(n);
            
            //开始找右子树中最小的结点(左边)，并删除
            while (n.left != null){
                if (n.left.left == null){
                	
                	if(n.left.right != null) {
                		n=n.left.right;
                	}else {
                    	n.left=null;
                	}
                	
                }else {
                n=n.left;
                }
            }

            //让x结点的左子树成为minNode的左子树
            minNode.left=x.left;
            //让x结点的右子树成为minNode的右子树
            if (minNode == n) {
				minNode.right = n.right;
			}else {
				minNode.right = n;
			}
            //让x结点的父结点指向minNode
           //假如删除的是根节点，这个方法首先会传入root节点，然后令x=root，所以对x进行的操作只能是对指向root的对象属性的操作。
            //如果只是单纯的x=minNode,这只能修改根节点之外的其他的节点，因为x只是一个引用，让x=minNode,这只是修改了赋给x的地址,而没有修改指向root的地址
            if (x==root) {
				root = minNode;
			}else {
				x = minNode;
			}
            }
        return x;
    }

    //获取树中元素的个数
    public int size(){
        return N;
    }

    //查找整个树中最小的键
    public Key min(){
        return min(root).key;
    }

    //在指定树x中找出最小键所在的结点
    private Node min(Node x){
        if (x.left != null){
            return min(x.left);
        }else {
            return x;
        }
    }

    //查找整个树中最大的键
    public Key max(){
        return max(root).key;
    }

    //在指定树x中找出最大键所在的结点
    private Node max(Node x){
        if (x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }

    //使用前序遍历，获取整个树中的所有键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }
    //获取指定树x中的所有键，并放到key队列中
    private void preErgodic(Node x,Queue<Key> keys){
        if (x == null){
            return;
        }
        //把x结点的key放到keys队列中
        keys.enqueue(x.key);

        //递归遍历x结点的左子树
        if (x.left != null){
            preErgodic(x.left,keys);
        }

        //递归遍历x结点的右子树
        if (x.right != null){
            preErgodic(x.right,keys);
        }
    }

    //使用中序遍历获取树中所有的键
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }
    //使用中序遍历获取指定树x中所有的键，并存放到keys中
    private void midErgodic(Node x,Queue<Key> keys){
        if (x == null)
            return;
        //先递归，把左子树中的键放到keys中
        if (x.left != null){
            midErgodic(x.left,keys);
        }

        //把当前结点x的键放到keys中
        keys.enqueue(x.key);

        //在递归，把右子树中的键放到keys中
        if (x.right != null){
            midErgodic(x.right,keys);
        }
    }

    //使用后序遍历获取树中所有的键
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }
    //使用后序遍历获取指定树x中所有的键，并存放到keys中
    private void afterErgodic(Node x,Queue<Key> keys){
        if (x == null)
            return;
        //先递归，把左子树中的键放到keys中
        if (x.left != null){
            afterErgodic(x.left,keys);
        }
        //在递归，把右子树中的键放到keys中
        if (x.right != null){
            afterErgodic(x.right,keys);
        }

        //把当前结点x的键放到keys中
        keys.enqueue(x.key);
    }

    //使用层序遍历，获取整个树中所有的键
    public Queue<Key> layerErgodic(){
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认将根结点放入队列中
        nodes.enqueue(root);

        while (nodes.size() != 0){
            //从队列中弹出一个结点,放入keys对列中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);

            //判断这个结点的左子树右子树是否为null
            if (n.left != null)
                nodes.enqueue(n.left);
            if (n.right != null)
                nodes.enqueue(n.right);
        }
        return keys;
    }

    //获取整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    //获取指定树x的最大深度
    private int maxDepth(Node x){
        if (x == null)
            return 0;

        int max=0;      //x的最大深度
        int maxL=0;     //左子树的最大深度
        int maxR=0;     //右子树的最大深度

        //计算左子树的最大深度
        if (x.left != null){
            maxL = maxDepth(x.left);
        }

        //计算右子树的最大深度
        if (x.right != null){
            maxR = maxDepth(x.right);
        }

        //比较左子树的最大深度和右子树的最大深度，取较大值+1
        max = (maxL>maxR ? maxL : maxR)+1;
        return max;
    }
}
