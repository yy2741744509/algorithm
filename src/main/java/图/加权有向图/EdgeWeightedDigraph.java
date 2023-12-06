package 图.加权有向图;/*
 *作者：yangyu
 *创建时间：2022/10/26 11:39
 */

import 队列.Queue;

public class EdgeWeightedDigraph {
    private final int V;    //记录顶点数量
    private int E;          //记录边数量
    private Queue<DirectedEdge>[] adj;  //邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    //向加权有向图中添加一条边
    public void addEdge(DirectedEdge e){
        //边e有方向，让e出现在起点的邻接表中
        int v = e.from();
        adj[v].enqueue(e);
        E++;
    }

    //获取由顶点v指出的所有边
    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }

    //或取加权有向图的所有边
    public Queue<DirectedEdge> edges(){
        Queue<DirectedEdge> allEdges = new Queue<>();
        for (int v=0; v<V; v++){
            for (DirectedEdge e : adj[v]) {
                allEdges.enqueue(e);
            }
        }
        return allEdges;
    }

    //获取图中顶点的数量
    public int V(){
        return V;
    }
    //获取图中边的数量
    public int E(){
        return E;
    }
}
