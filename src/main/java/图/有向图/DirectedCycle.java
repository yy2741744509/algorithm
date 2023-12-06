package 图.有向图;/*
 *作者：yangyu
 *创建时间：2022/10/23 17:00
 */

import 图.有向图.Digraph;

import java.util.Arrays;

public class DirectedCycle {
    private boolean[] marked;       //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean hasCycle;       //记录图中是否有环
    private boolean[] onStack;      //索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上

    public DirectedCycle(Digraph G){
        int l = G.V();
        this.marked = new boolean[l];
        this.hasCycle = false;
        this.onStack = new boolean[l];
        //找到图中每一个顶点，让每一个顶点作为入口，调用一次dfs进行搜索
        for (int v = 0; v < l; v++) {
            //判断如果当前顶点还没有搜索过，则调用dfs进行搜索
            if ( !marked[v] ){
                dfs(G,v);
            }
        }
    }

    //基于DFS，检测图G中是否有环
    private void dfs(Digraph G, int v){
        marked[v] = true;
        onStack[v] = true;
        for (Integer w : G.adj(v)) {
            if ( !marked[w] ){
                //System.out.print(w+"--");
                dfs(G,w);
            }

            //如果在栈中，则检测到有环
            if ( onStack[w] ){
                hasCycle = true;
            }
        }
        //把当前顶点出栈
        onStack[v] = false;
    }

    //判断当前有向图G中是否有环
    public boolean hasCycle(){
        return hasCycle;
    }
}
