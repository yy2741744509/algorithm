package 图.有向图;/*
 *作者：yangyu
 *创建时间：2022/10/24 11:49
 */

import 图.有向图.Digraph;
import 栈.Stack;

public class DepthFirstOrder {
    private boolean[] marked;           //索引代表顶点，值表示当前顶点是否已经被搜索
    private Stack<Integer> reversePost; //使用栈，存储顶点序列

    public DepthFirstOrder(Digraph G) {
        this.marked = new boolean[G.V()];
        this.reversePost = new Stack<Integer>();

        for (int v = 0; v < G.V(); v++) {
            if ( !marked[v] ){
                dfs(G,v);
            }
        }
    }

    //基于深度优先搜索，生成顶点线性序列
    private void dfs(Digraph G, int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if ( !marked[w] ){
                dfs(G,w);
            }
        }
        reversePost.push(v);
    }

    //获取顶点线性序列
    public Stack<Integer> reversePost(){
        return reversePost;
    }
}
