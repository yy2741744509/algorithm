package 图.加权无向图;/*
 *作者：yangyu
 *创建时间：2022/10/24 13:31
 */
public class Edge implements Comparable<Edge> {
    private final int V;        //顶点一
    private final int W;        //顶点二
    private final double weight;//当前边的权重

    //通过顶点v和w，以及权重weight的值构造一个边对象
    public Edge(int v, int w, double weight) {
        this.V = v;
        this.W = w;
        this.weight = weight;
    }

    //获取边的权重值
    public double weight(){
        return weight;
    }

    //获取边上的一个点
    public int either(){
        return V;
    }

    //获取边上除了顶点vertex外的另一个顶点
    public int other(int vertex){
        return V^W^vertex;  //如果vertex == V return W
    }

    //比较 当前边 和 参数that边 的权重，如果当前边权重大，返回1，相等返回0，小则返回-1
    public int compareTo(Edge that){
        int cmp;
        if ( this.weight()>that.weight() ){
            cmp = 1;
        }else if ( this.weight()<that.weight() ){
            cmp = -1;
        }else {
            cmp = 0;
        }
        return cmp;
    }
}
