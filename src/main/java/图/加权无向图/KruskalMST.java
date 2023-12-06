package 图.加权无向图;/*
 *作者：yangyu
 *创建时间：2022/10/25 21:08
 */

import 优先队列.MinPriorityQueue;
import 并查集.UF_Tree_Weighted;
import 队列.Queue;

public class KruskalMST {
    private Queue<Edge> mst;        //保存最小生成树的所有边
    private UF_Tree_Weighted uf;    //索引代表顶点，使用uf.connect(v, w)可以判断顶点v和w是否在同一颗树中，使用uf.union(v, w)可以把顶点v所在的树和顶点w所在的树合并
    private MinPriorityQueue<Edge> pq;  //pq存储图中所有的边，使用最小优先队列，对边按照权重进行排序

    public KruskalMST(EdgeWeightedGraph G) {
        int vSize = G.V();
        this.mst = new Queue<Edge>();
        this.uf = new UF_Tree_Weighted(vSize);
        this.pq = new MinPriorityQueue<>(G.E()+1);
        //把图中所有的边存储到pq中
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        //遍历pq队列，拿到最小权重的边,进行处理
        while ( !pq.isEmpty() && mst.size()<vSize-1 ){
            //找到权重最小的边
            Edge minEdge = pq.delMin();
            //找到该边的两个顶点
            int v = minEdge.either();
            int w = minEdge.other(v);
            //判断这两个顶点是否已经在同一颗树中
            if (uf.connected(v,w)){
                continue;
            }
            //合并两颗树
            uf.union(v,w);
            //让minEdge进入mst队列中
            mst.enqueue(minEdge);
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges(){
        return mst;
    }
}
