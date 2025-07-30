package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main23286 {

    /**
     * 허들넘기
     * 골드3
     * https://www.acmicpc.net/problem/23286
     */



    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int testNum = Integer.parseInt(st.nextToken());

        List<Point>[] graph = new ArrayList[nodeNum+1];

        for (int i = 1; i <= nodeNum; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            graph[start].add(new Point(end, height));
        }

        for (int t = 0; t < testNum; t++) {

            boolean[] visited = new boolean[nodeNum+1];
            int[] result = new int[nodeNum+1];

            for (int i = 1; i <= nodeNum; i++) {
                result[i] = Integer.MAX_VALUE;
            }

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


            Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.height));
            queue.add(new Point(start, 0));
            result[start] = 0;

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (visited[now.end]) {
                    continue;
                }
                visited[now.end] = true;

                for (Point next : graph[now.end]) {
                    if (next.height < result[next.end]) {
                        result[next.end] = next.height;
                        queue.add(new Point(next.end, result[next.end]));
                    }
                }

            }

            System.out.println(result[end] == Integer.MAX_VALUE ? -1 : result[end]);

        }
    }


    private static class Point {
        int end;
        int height;

        Point(int end, int height) {
            this.end = end;
            this.height = height;
        }
    }





}
