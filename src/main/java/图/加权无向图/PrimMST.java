package 图.加权无向图;/*
 *作者：yangyu
 *创建时间：2022/10/25 14:45
 */

import 优先队列.索引优先队列.IndexMinPriorityQueue;
import 队列.Queue;

import java.util.Arrays;

public class PrimMST {
    private Edge[] edgeTo;      //索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private double[] distTo;    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private boolean[] marked;   //如果当前顶点已经在树中，则值为true，否则为false
    private IndexMinPriorityQueue<Double> pq;   //存放树中顶点与非树中顶点之间的有效横切边

    //根据一副加权无向图，创建最小生成树计算对象
    public PrimMST(EdgeWeightedGraph G) {
        int v = G.V();
        this.edgeTo = new Edge[v];
        this.distTo = new double[v];
        Arrays.fill(this.distTo,Double.POSITIVE_INFINITY);
        this.marked = new boolean[v];
        this.pq = new IndexMinPriorityQueue<Double>(v);

        //默认让0进入树中,但是树中只有一个顶点0
        //因此，0顶点默认没有和其它顶点相连，所有让distTo对应位置存储的值为0.0
        distTo[0] = 0.0;
        pq.insert(0,0.0);

        //遍历索引优先队列，拿到最小横切边对应的顶点，把该顶点加入到最小生成树中
        while ( !pq.isEmpty() ){
            visit(G,pq.delMin());
        }
    }

    //将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if ( marked[w] ){
                continue;
            }
            //判断边e的权重是否小于 从w顶点到树中已经存在的最小边的权重
            if ( e.weight() < distTo[w] ){
                edgeTo[w] = e;
                distTo[w] =e.weight();
                if (pq.contains(w)){
                    pq.changeItem(w,e.weight());
                }else {
                    pq.insert(w,e.weight());
                }
            }
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges(){
        Queue<Edge> allEdges = new Queue<>();
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null){
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}
