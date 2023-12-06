package 二叉树;/*
 *作者：yangyu
 *创建时间：2022/10/11 22:47
 */
import 队列.Queue;
public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();
        tree.put("B","2");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("C","3");

        Queue<String> keys1 = tree.preErgodic();
        Queue<String> keys2 = tree.midErgodic();
        Queue<String> keys3 = tree.afterErgodic();
        Queue<String> keys4 = tree.layerErgodic();

        System.out.println("========前序遍历========");
        for (String key : keys1){
            System.out.println(key+"-----"+tree.get(key));
        }
        System.out.println("========中序遍历========");
        for (String key : keys2){
            System.out.println(key+"-----"+tree.get(key));
        }
        System.out.println("========后序遍历========");
        for (String key : keys3){
            System.out.println(key+"-----"+tree.get(key));
        }
        System.out.println("========层序遍历========");
        for (String key : keys4){
            System.out.println(key+"-----"+tree.get(key));
        }
    }
}
