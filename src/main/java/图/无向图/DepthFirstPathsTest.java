package 图.无向图;/*
 *作者：yangyu
 *创建时间：2022/10/23 13:46
 */

import 栈.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DepthFirstPathsTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(DepthFirstPathsTest.class.getClassLoader().getResourceAsStream("road_find.txt")));
        int totalNumber = Integer.parseInt(br.readLine());
        Graph G = new Graph(totalNumber);
        int edgeNumbers = Integer.parseInt(br.readLine());
        for (int i=1; i<=edgeNumbers; i++){
            String edge = br.readLine();
            String[] str = edge.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            G.addEdge(v,w);
        }
        //构建路径查找对象，并设置起点为0
        DepthFirstPaths paths = new DepthFirstPaths(G, 0);
        //查找从起点0到终点4的路径，返回stack
        Stack<Integer> path = paths.pathTo(4);

        StringBuilder sb = new StringBuilder();
        //遍历栈对象
        for (Integer v : path) {
            sb.append(v+"-");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }
}
