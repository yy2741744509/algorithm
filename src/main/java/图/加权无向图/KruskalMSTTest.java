package 图.加权无向图;/*
 *作者：yangyu
 *创建时间：2022/10/25 16:21
 */

import 队列.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KruskalMSTTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(KruskalMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));
        int total = Integer.parseInt(br.readLine());

        //构建图
        EdgeWeightedGraph G = new EdgeWeightedGraph(total);
        int edgeNumbers = Integer.parseInt(br.readLine());

        for (int e = 1; e <= edgeNumbers; e++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);
            //构建加权无向边
            Edge edge = new Edge(v, w, weight);
            G.addEdge(edge);
        }

        KruskalMST kruskalMST = new KruskalMST(G);
        Queue<Edge> edges = kruskalMST.edges();
        for (Edge e : edges) {
            int v = e.either();
            int w = e.other(v);
            double weight = e.weight();
            System.out.println(v+"--"+w+" :: "+weight);
        }
    }
}
