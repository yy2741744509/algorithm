package 二叉树;/*
 *作者：yangyu
 *创建时间：2022/10/11 22:47
 */

import 队列.Queue;

public class BinaryTreeDepthTest {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

        int maxDepth = tree.maxDepth();
        System.out.println("maxDepth:"+maxDepth);
    }
}
