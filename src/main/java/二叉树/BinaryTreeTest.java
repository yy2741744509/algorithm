package 二叉树;/*
 *作者：yangyu
 *创建时间：2022/10/11 21:14
 */

public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        //测试插入
        tree.put(3,"张三");
        tree.put(2,"李四");
        tree.put(1,"王五");
        tree.put(4,"赵六");
        tree.put(5,"洪七");
        System.out.println("插入完毕后元素的个数："+tree.size());
        
        tree.delete(3);
        tree.delete(2);
        tree.delete(1);
        tree.delete(4);
        tree.delete(5);
        
        System.out.println("删除后元素的个数："+tree.size());
        System.out.println("删除后,键3对应的元素："+tree.get(3));
        System.out.println("删除后,键2对应的元素："+tree.get(2));
        System.out.println("删除后,键1对应的元素："+tree.get(1));
        System.out.println("删除后,键4对应的元素："+tree.get(4));
        System.out.println("删除后,键5对应的元素："+tree.get(5));

        
      
        
    }
}
