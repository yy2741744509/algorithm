package 图.无向图;/*
 *作者：yangyu
 *创建时间：2022/10/22 18:57
 */
public class DepthFirstSearchTest {
    public static void main(String[] args) {
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);

        G.addEdge(7,8);

        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);

        DepthFirstSearch search = new DepthFirstSearch(G, 0);
        int count = search.count();
        System.out.println("与起点 0 相通的顶点数量为："+count);

        //测试某个顶点与起点是否相通
        boolean marked5 = search.marked(5);
        System.out.println("顶点5与顶点0是否相通："+marked5);
        boolean marked7 = search.marked(7);
        System.out.println("顶点7与顶点0是否相通："+marked7);
    }
}
