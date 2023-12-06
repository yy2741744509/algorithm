package 图.加权有向图;/*
 *作者：yangyu
 *创建时间：2022/10/26 12:45
 */

import 优先队列.索引优先队列.IndexMinPriorityQueue;
import 栈.Stack;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;      //索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private double[] distTo;            //索引代表顶点，值表示从顶点s到当前顶点的最短路径的总权重
    private IndexMinPriorityQueue<Double> pq;       //存放树中顶点与非树中顶点之间的有效横切边

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        this.pq = new IndexMinPriorityQueue<>(G.V());
        //默认让顶点s进入到最短路径树中
        distTo[s] = 0.0;
        pq.insert(s,0.0);
        //遍历pq
        while ( !pq.isEmpty() ){
            relax(G,pq.delMin());
        }
    }

    //松弛图G中的顶点v
    private void relax(EdgeWeightedDigraph G, int v){
        for (DirectedEdge edge : G.adj(v)) {
            //获取到该边的终点w
            int w = edge.to();
            //通过松弛技术，判断从起点s到顶点w的最短路径是否需要先从顶点s到顶点v，然后在从顶点v到顶点w
            if (distTo[v]+edge.weight() < distTo[w]){
                distTo[w] = distTo[v]+edge.weight();
                edgeTo[w] = edge;
                //判断pq中是否已经存在顶点w，如果存在，则更新权重，如果不存在，则直接添加
                if (pq.contains(w)){
                    pq.changeItem(w,distTo(w));
                }else {
                    pq.insert(w,distTo(w));
                }
            }
        }
    }

    //获取从顶点s到顶点v的最短路径的总权重
    public double distTo(int v){
        return distTo[v];
    }

    //判断从顶点s到顶点v是否可达
    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    //查询从起点s到顶点v的最短路径中的所有边
    public Stack<DirectedEdge> pathTo(int v){
        //从顶点s到顶点v是否可达
        if ( !hasPathTo(v) ){
            return null;
        }
        Stack<DirectedEdge> allEdges = new Stack<>();
        while (true){
            DirectedEdge e = edgeTo[v];
            if (e == null){
                break;
            }
            allEdges.push(e);
            v=e.from();
        }
        return allEdges;
    }
}
