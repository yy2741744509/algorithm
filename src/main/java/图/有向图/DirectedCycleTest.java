package 图.有向图;/*
 *作者：yangyu
 *创建时间：2022/10/23 21:36
 */

public class DirectedCycleTest {
    public static void main(String[] args) {
        Digraph G = new Digraph(7);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(6,4);
        G.addEdge(4,5);
        G.addEdge(5,3);
        G.addEdge(5,0);
        G.addEdge(3,4);
        DirectedCycle cycle = new DirectedCycle(G);
        System.out.println("图中是否有环："+cycle.hasCycle());
    }
}
