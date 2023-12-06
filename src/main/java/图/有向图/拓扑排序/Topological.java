package 图.有向图.拓扑排序;/*
 *作者：yangyu
 *创建时间：2022/10/24 12:22
 */

import 图.有向图.DepthFirstOrder;
import 图.有向图.Digraph;
import 图.有向图.DirectedCycle;
import 栈.Stack;

public class Topological {
    private Stack<Integer> order;

    public Topological(Digraph G) {
        //创建检测环对象
        DirectedCycle cycle = new DirectedCycle(G);
        //判断G图中是否有环,没有则进行顶点排序：创建一个顶点排序对象
        if ( !cycle.hasCycle() ){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    //判断图G是否有环
    public boolean isCycle(){
        return order == null;
    }

    //获取拓扑排序的所有顶点
    public Stack<Integer> order(){
        return order;
    }
}
