package 链表;/*
 *作者：yangyu
 *创建时间：2022/9/20 20:07
 */

public class TestBracketMatch {
    public static void main(String[] args) {
        String exp1="[1*(2+3)]/(5-3)";
        String exp2="[(])";
        BracketMatch bracketMatch = new BracketMatch();

        System.out.println(exp1+"---表达式括号匹配"+(bracketMatch.match(exp1)?"成功":"失败"));

        System.out.println(exp2+"---表达式括号匹配"+(bracketMatch.match(exp2)?"成功":"失败"));

    }
}
