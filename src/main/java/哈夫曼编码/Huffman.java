package 哈夫曼编码;/*
 *作者：yangyu
 *创建时间：2022/10/27 13:21
 */
import java.util.*;

public class Huffman {
    public static HashMap huffman = null;
    public static void main(String[] args) {
        String str = "奇变偶不变符号看象限";
        System.out.println("编码前："+str);
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char key : chars) {
            if(map.containsKey(key))
                continue;
            map.put(key,0);
        }

        //计算每个字符出现的次数
        for (char key : chars) {
            if (map.containsKey(key)){
                Integer value = map.get(key);
                map.put(key,++value);
            }
        }

        //构建最小权重优先队列,使用上浮算法进行堆排序
        MinWeightedPriorityQueue queue = new MinWeightedPriorityQueue(map.size());

        //遍历集合创建森林
        Set<Character> set = map.keySet();
        for (Character key : set){
            Integer value = map.get(key);
            queue.insert( new Node(key,value,null,null));
        }

        //构建Huffman树
        while ( queue.size()>1 ){
            //取出两个最小的权重值结点
            Node nodeLeft =  queue.delMin();
            Node nodeRight =  queue.delMin();
            //左为0，右为1
            nodeLeft.setEncode("0");
            nodeRight.setEncode("1");
            //插入一个新结点
            Integer leftValue = nodeLeft.getValue();
            Integer rightValue = nodeRight.getValue();
            Node newNode = new Node(null, leftValue+rightValue, nodeLeft, nodeRight);
            queue.insert(newNode);
        }

        //编码
        huffman = new HashMap();
        Node root = queue.delMin();
        buildHuffmanCode(root);

        //打印结果
        System.out.print("\n编码后：");
        for (char aChar : chars) {
            if(huffman.containsKey(aChar)){
                System.out.print(huffman.get(aChar));
            }
        }

    }
    /**
     * 遍历哈夫曼树，并且进行编码
     */
    public static void buildHuffmanCode(Node root) {
        if (root.getLeft() != null) {
            //root.getLeftChild().getCode()是现在正在遍历节点的编码，root.getCode()是之前的编码，两者要相加
            root.getLeft().setEncode(root.getEncode() + root.getLeft().getEncode());
            buildHuffmanCode(root.getLeft());
        }
        if (root.getRight() != null) {
            root.getRight().setEncode(root.getEncode() + root.getRight().getEncode());
            buildHuffmanCode(root.getRight());
        }
        if (root.getKey()!=null) {
            System.out.println("'"+root.getKey() +"'"+ " ====> " +root.getEncode());
            huffman.put(root.getKey(), root.getEncode());
        }
    }
}
