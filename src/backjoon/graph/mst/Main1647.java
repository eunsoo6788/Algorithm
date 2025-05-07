package backjoon.graph.mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1647 {

    /**
     * 도시 분할 계획
     * 골드4
     * MST
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
    private static long sum =0;
    private static int max =0;
    private static int nodes;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        result = new int[nodes+1];
        visited = new boolean[nodes+1];
        lists = new List[nodes+1];

        for (int i = 1; i <= nodes; i++) {
            result[i] = Integer.MAX_VALUE;
            lists[i] = new ArrayList<>();
        }

        int minStart = 0;
        int minWeight = Integer.MAX_VALUE;

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, weight));
            lists[b].add(new Node(a, weight));

            if (minWeight > weight) {
                minWeight = weight;
                minStart = a;
            }

        }


        bfs(minStart);

        System.out.println(sum-max);

    }

    private static void bfs(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.end]) {
                continue;
            }
            visited[node.end] = true;
            sum += node.weight;
            max = Math.max(max, node.weight);

            for (Node next : lists[node.end]) {
                if (!visited[next.end]) {
                    pq.add(new Node(next.end, next.weight));
                }
            }

        }


    }
}
