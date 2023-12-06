package 图.无向图;/*
 *作者：yangyu
 *创建时间：2022/10/23 11:12
 */

import 并查集.公路修建问题.Traffic_Project_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traffic_Project_Test2 {
    public static void main(String[] args) throws IOException {
        //构建一个缓冲读取流BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(Traffic_Project_Test2.class.getClassLoader().getResourceAsStream("traffic_project.txt")));
        //读取第一行数据20
        int totalNumber = Integer.parseInt(br.readLine());
        //创建一个Graph对象
        Graph G = new Graph(totalNumber);
        int roadNumber = Integer.parseInt(br.readLine());

        for (int i = 1; i <= roadNumber; i++) {
            String road = br.readLine();
            String[] str = road.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            G.addEdge(v,w);
        }

        DepthFirstSearch search = new DepthFirstSearch(G, 9);

        System.out.println("顶点 8 和顶点 9 是否相通："+search.marked(8));
        System.out.println("顶点 10 和顶点 9 是否相通："+search.marked(10));
    }
}
