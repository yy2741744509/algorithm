package 图.无向图;/*
 *作者：yangyu
 *创建时间：2022/10/22 17:32
 */

public class DepthFirstSearch {
    private boolean[] marked;         //索引代表顶点，值代表当前顶点是否已经被搜索
    private int count;                //记录有多少个顶点与s顶点相通

    //构造深度优先搜索对象，使用深度优先搜索找出G图中 s 顶点的所有相通顶点
    public DepthFirstSearch(Graph G, int s){
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G, s);
    }

    //使用深度优先搜索找出G图中 v 顶点的所有相通顶点
    private void dfs(Graph G, int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            //判断当前w顶点有没有被搜索过，如果没有被搜索过，则递归调用dfs方法进行深度搜索
            if ( !marked[w]){
                dfs(G, w);
                System.out.print(w+" ");
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
