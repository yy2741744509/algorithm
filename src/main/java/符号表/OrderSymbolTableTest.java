package 符号表;/*
 *作者：yangyu
 *创建时间：2022/10/11 12:41
 */

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> table = new OrderSymbolTable<>();
        table.put(1,"张三");
        table.put(2,"李四");
        table.put(4,"赵六");
        table.put(7,"田七");

        table.put(3,"王五");

    }
}
