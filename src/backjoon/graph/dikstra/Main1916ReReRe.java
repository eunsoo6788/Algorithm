package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1916ReReRe {

    /**
     * 최소비용 구하기
     * 골드3
     * https://www.acmicpc.net/problem/1916
     */



    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        int[] result = new int[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];
        List<Point>[] nodes = new List[nodeNum+1];

        for (int i = 1; i <= nodeNum; i++) {
            nodes[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[start].add(new Point(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        queue.add(new Point(start,0));
        result[start] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Point next : nodes[now.end]) {

                if (next.weight + now.weight < result[next.end]) {
                    result[next.end] = next.weight + now.weight;
                    queue.add(new Point(next.end, result[next.end]));
                }
            }
        }

        System.out.println(result[end]);


    }


    private static class Point {
        int end;
        int weight;

        Point(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }





}
