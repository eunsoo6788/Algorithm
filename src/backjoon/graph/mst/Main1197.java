package backjoon.graph.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1197 {

    /**
     * 최소 스패닝 트리
     * 골드4
     * MST (
     */

    private static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static int[] result;
    private static boolean[] visited;
    private static List<Node>[] lists;
    private static int sum = 0;


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        result = new int[nodes+1];
        visited = new boolean[nodes+1];
        lists = new List[nodes+1];

        for (int i = 1; i <= nodes; i++) {
            result[i] = Integer.MAX_VALUE;
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edges; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }


        bfs();

        System.out.println(sum);





    }


    private static void bfs() {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(1,0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;
            sum += now.weight;

            for (Node next : lists[now.end]) {
                if (!visited[next.end]) {
                    pq.add(new Node(next.end, next.weight));
                }
            }

        }
    }
}
