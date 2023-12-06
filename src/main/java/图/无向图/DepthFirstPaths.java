package 图.无向图;/*
 *作者：yangyu
 *创建时间：2022/10/23 11:32
 */

import 栈.Stack;

public class DepthFirstPaths {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s){
        this.marked = new boolean[G.V()];
        this.s = s;
        this.edgeTo = new int[G.V()];

        dfs(G,s);
    }

    //使用深度优先搜索找出G图中v顶点的所有相邻顶点
    private void dfs(Graph G, int v){
        //把v标识为以搜索
        marked[v] = true;
        //遍历顶点v的邻接表，拿到每一个相邻的顶点，继续递归搜索
        for (Integer w : G.adj(v)) {
            if ( !marked[w] ){
                edgeTo[w] = v;  //到达顶点w的路径上的最后一个顶点是v
                dfs(G,w);
            }
        }
    }

    //判断v顶点与s顶点是否存在路径
    public boolean hasPathTo(int v){
        return marked[v];
    }

    //找出从起点s到顶点v的路径(就是该路径经过的顶点){
    public Stack<Integer> pathTo(int v){
        //如果没有被搜索过，返回null
        if ( !hasPathTo(v) )
            return null;
        Stack<Integer> path = new Stack<>();

        //从顶点v开始，一直往前找，找到起点为止
        for (int x=v; x!=s; x=edgeTo[x]){
            path.push(x);
        }
        //把起点s放到栈中
        path.push(s);
        return path;
    }
}
