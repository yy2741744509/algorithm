package 图.加权有向图;/*
 *作者：yangyu
 *创建时间：2022/10/26 11:32
 */

public class DirectedEdge {
    private final int v;    //起点
    private final int w;    //终点
    private final double weight;    //当前边的权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //获取边的权重值
    public double weight(){
        return weight;
    }

    //获取有向边的起点
    public int from(){
        return v;
    }

    //获取有向边的终点
    public int to(){
        return w;
    }
}
