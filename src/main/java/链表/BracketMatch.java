package 链表;/*
 *作者：yangyu
 *创建时间：2022/9/20 19:53
 */

import 栈.Stack;

public class BracketMatch {
    public boolean match(String str){
        Stack<Character> stack=new Stack<>();
        char[] chs=str.toCharArray();
        for (char ch:chs){
            //如果是左括号，则进栈
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')'){
                //如果是右括号
                //判断栈是否为空，且括号是否是同一类
                if (!stack.isEmpty() && stack.peek().equals('('))
                    stack.pop(); //条件成立则栈顶元素出栈
                else
                    return false;
            }else if (ch == ']'){
                if (!stack.isEmpty() && stack.peek().equals('['))
                    stack.pop();
                else
                    return false;
            }
        }
        //检查结束，判断是否空
        return stack.isEmpty();
    }
}
