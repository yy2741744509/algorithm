package 图.加权有向图;/*
 *作者：yangyu
 *创建时间：2022/10/26 20:48
 */

import 栈.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DijkstraSPTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));
        int total = Integer.parseInt(br.readLine());
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(total);
        int edgeNumber = Integer.parseInt(br.readLine());

        for (int i = 1; i <= edgeNumber; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);
            DirectedEdge directedEdge = new DirectedEdge(v, w, weight);
            G.addEdge(directedEdge);
        }
        DijkstraSP dijkstraSP = new DijkstraSP(G, 0);
        //查找0->6的最短路径
        Stack<DirectedEdge> edges = dijkstraSP.pathTo(6);
        for (DirectedEdge e : edges) {
            System.out.printf("%d -> %d  ::  %3.1f\n",e.from(),e.to(),e.weight());
        }

    }
}
