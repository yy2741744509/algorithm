package 图.有向图.拓扑排序;/*
 *作者：yangyu
 *创建时间：2022/10/24 12:42
 */

import 图.有向图.Digraph;
import 栈.Stack;

public class TopoLogicalTest {
    public static void main(String[] args) {
        Digraph G = new Digraph(6);
        G.addEdge(0,2);
        G.addEdge(0,3);
        G.addEdge(2,4);
        G.addEdge(3,4);
        G.addEdge(4,5);
        G.addEdge(1,3);

        Topological topoLogical = new Topological(G);
        Stack<Integer> order = topoLogical.order();

        StringBuilder sb = new StringBuilder();
        for (Integer w : order) {
            sb.append(w+"->");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
