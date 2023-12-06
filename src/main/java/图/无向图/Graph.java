package 图.无向图;/*
 *作者：yangyu
 *创建时间：2022/10/22 15:14
 */
import 队列.Queue;
public class Graph {
    //记录顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int V){
        this.V = V;     //初始化顶点数量
        this.E = 0;     //初始化边的数量
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

    //向图中添加一条边v-w
    public void addEdge(int v, int w){
        //在无向图中边是没有方向的，边可以是v到w，又可以是w-v
        //所有，需要让w出现在v的邻接表中，并且还要让v出现在w的邻接表中
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        //边的数量+1
        E++;
    }

    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
