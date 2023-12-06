package 图.无向图;/*
 *作者：yangyu
 *创建时间：2022/10/22 17:32
 */

import 队列.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;         //索引代表顶点，值代表当前顶点是否已经被搜索
    private int count;                //记录有多少个顶点与s顶点相通
    private Queue<Integer> waitSearch;//用来存储待搜索邻接表的点

    //构造广度优先搜索对象，使用深度优先搜索找出G图中 s 顶点的所有相通顶点
    public BreadthFirstSearch(Graph G, int s){
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new Queue<Integer>();
        bfs(G, s);
    }

    //使用广度优先搜索找出G图中 v 顶点的所有相通顶点
    private void bfs(Graph G, int v){
        marked[v] = true;

        //让顶点v进入待搜索队列
        waitSearch.enqueue(v);
        //如果队列不为空，则从队列中弹出一个待搜索的顶点进行搜索
        while ( !waitSearch.isEmpty() ){
            Integer wait = waitSearch.dequeue();
            //遍历wait顶点的邻接表
            for (Integer w : G.adj(wait)) {
                if ( !marked[w] ) {
                    //bfs(G,w);
                    waitSearch.enqueue(w);
                    marked[w] = true;
                    count++;
                }
            }
        }
        //相通顶点数量+1
        count++;
    }

    //判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与顶点s相通的所有顶点的总数
    public int count(){
        return count;
    }
}
