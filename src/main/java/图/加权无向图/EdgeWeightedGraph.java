package 图.加权无向图;/*
 *作者：yangyu
 *创建时间：2022/10/24 21:40
 */

import org.omg.PortableServer.THREAD_POLICY_ID;
import 队列.Queue;

public class EdgeWeightedGraph {
    private final int V;        //记录顶点数量
    private int E;              //记录边数量
    private Queue<Edge>[] adj;  //邻接表

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
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

    //向加权无向图中加一条边
    public void addEdge(Edge e){
        //需要让边e同时出现在e这个边的两个顶点的邻接表中
        int v = e.either();
        int w = e.other(v);

        adj[v].enqueue(e);
        adj[w].enqueue(e);

        this.E++;
    }

    //获取和顶点v关联的所有边
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    //获取加权无向图的所有边
    public Queue<Edge> edges(){
        Queue<Edge> allEdges = new Queue<Edge>();
        //遍历图中的每一个顶点，找到该顶点的邻接表,邻接表中存储了该顶点关联的没一条边
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (e.other(v)<v){
                    allEdges.enqueue(e);
                }
            }
        }
        return allEdges;
    }
}
