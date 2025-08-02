package backjoon.graph.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main20010 {

    /**
     * 전기가 부족해
     * 골드3
     * MST
     */

    private static class Node {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static class Point {
        int end;
        int weight;

        public Point(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static int[] result;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        result = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            result[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight =Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }

        List<Point>[] nodeList = new List[nodes];
        for (int i = 0; i < nodes; i++) {
            nodeList[i] = new ArrayList<>();
        }

        int sum = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int start = find(now.start);
            int end = find(now.end);

            if (start != end) {

                sum += now.weight;
                union(start, end);
                nodeList[now.start].add(new Point(now.end, now.weight));
                nodeList[now.end].add(new Point(now.start, now.weight));
            }
        }

        System.out.println(sum);


        for (int i = 0; i < nodes; i++) {
            visited = new boolean[nodes];
            visited[i] = true;
            dfs(i, nodeList, 0);
        }

        System.out.println(max);


    }

    private static int max = 0;
    private static boolean[] visited;
    private static void dfs(int start,List<Point>[] nodeList, int sum) {

        max = Math.max(max, sum);

        for (int i = 0; i < nodeList[start].size(); i++) {
            Point now = nodeList[start].get(i);
            if (!visited[now.end]) {
                visited[now.end] = true;
                dfs(now.end, nodeList, sum + now.weight);
            }

        }

    }


    private static int find(int x) {
        if (x == result[x]) {
            return x;
        }
        return result[x] = find(result[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (y > x) {
                result[y] = x;
            } else {
                result[x] = y;
            }
        }
    }
}
