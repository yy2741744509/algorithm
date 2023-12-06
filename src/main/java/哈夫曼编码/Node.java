package 哈夫曼编码;/*
 *作者：yangyu
 *创建时间：2022/10/27 15:50
 */

public class Node {
    //存储键
    private Character key;
    //存储值
    private Integer value;
    //记录左子结点
    private Node left;
    //记录右子结点
    private Node right;
    //记录编码
    private String encode="";

    public Node(Character key, Integer value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Character getKey() {
        return key;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

}
