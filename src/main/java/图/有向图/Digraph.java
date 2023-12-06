package 图.有向图;/*
 *作者：yangyu
 *创建时间：2022/10/23 15:00
 */

import 队列.Queue;

public class Digraph {
    //记录顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    //获取图中顶点的数量
    public int V(){
        return V;
    }

    //获取图中边的数量
    public int E(){
        return E;
    }

    //向有向图中添加一条边v-->w
    public void addEdge(int v, int w){
        //让顶点w 出现在顶点v 的邻接表中
        adj[v].enqueue(w);
        E++;
    }

    //获取由v指出的边所连接的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    //该图的反向图
    private Digraph reverse(){
        Digraph r = new Digraph(V);
        for (int v=0; v<V; v++){
            for (Integer w : adj[v]) {
                addEdge(w,v);
            }
        }
        return r;
    }
}
