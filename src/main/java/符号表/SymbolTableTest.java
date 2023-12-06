package 符号表;/*
 *作者：yangyu
 *创建时间：2022/10/2 16:00
 */

public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> symbolTable = new SymbolTable<>();

        symbolTable.put(1,"张三");
        symbolTable.put(2,"李四");
        symbolTable.put(3,"王五");
        symbolTable.put(4,"赵六");
        symbolTable.put(5,"田七");
        symbolTable.put(6,"刘八");
        System.out.printf("插入完毕后，元素个数为:%d\n",symbolTable.size());

        symbolTable.put(2,"孙悟空");
        System.out.printf("替换完毕后，元素个数为:%d\n",symbolTable.size());

        //测试get
        System.out.println(symbolTable.get(2));

        //测试删除
        symbolTable.delete(2);
        System.out.printf("删除完毕后，元素个数为:%d\n",symbolTable.size());
    }
}
