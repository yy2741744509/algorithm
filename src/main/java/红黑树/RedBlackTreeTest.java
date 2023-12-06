package 红黑树;/*
 *作者：yangyu
 *创建时间：2022/10/18 14:09
 */

public class RedBlackTreeTest {
    public static void main(String[] args) {
        //创建红黑树
        RedBlackTree<String, String> tree = new RedBlackTree<>();

        //插入
        tree.put("1","张三");
        tree.put("2","李四");
        tree.put("3","王五");
        tree.put("4","赵六");
        tree.put("5","田七");

        //获取元素
        System.out.println(tree.get("1"));
        System.out.println(tree.get("2"));
        System.out.println(tree.get("3"));
    }
}
