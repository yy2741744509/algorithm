package 栈.逆波兰表达式;/*
 *作者：yangyu
 *创建时间：2022/9/27 12:32
 */

import 栈.Stack;

public class Inverse_Polish_expression {
    public static void main(String[] args) {
        String[] notation={"5","7","+","9","*"};
        System.out.println(caculate(notation));

    }

    public static int caculate(String[] notation){
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];

            Integer o1;
            Integer o2;
            Integer result;

            switch (curr){
                case "+":
                    o1=stack.pop();
                    o2=stack.pop();
                    result=o2+o1;
                    stack.push(result);
                    break;

                case "-":
                    o1=stack.pop();
                    o2=stack.pop();
                    result=o2-o1;
                    stack.push(result);
                    break;

                case "*":
                    o1=stack.pop();
                    o2=stack.pop();
                    result=o2*o1;
                    stack.push(result);
                    break;

                case "/":
                    o1=stack.pop();
                    o2=stack.pop();
                    result=o2/o1;
                    stack.push(result);
                    break;

                default:
                    //操作数，放入栈中
                    stack.push(Integer.parseInt(curr));
                    break;
            }

        }
        return stack.pop();
    }
}
