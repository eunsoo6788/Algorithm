package backjoon.graph.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main20007 {

    /**
     * 떡 돌리기
     * 골드4
     * 다익스트라
     */

    private static class Node {
        private int end;
        private int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

    }


    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());


        int[] results = new int[nodeNum + 1];
        boolean[] visited = new boolean[nodeNum + 1];
        List<Node>[] lists = new List[nodeNum + 1];

        for (int i = 0; i < nodeNum + 1; i++) {
            lists[i] = new ArrayList<>();
            results[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(startNode, 0));
        results[startNode] = 0;

        int day = 0;
        int distance = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;


            for (Node next : lists[now.end]) {
                if (now.weight + next.weight < results[next.end]) {
                    results[next.end] = now.weight + next.weight;
                    pq.add(new Node(next.end, results[next.end]));
                }
            }


        }

        Arrays.sort(results);

        for (int i = 0; i <= nodeNum; i++) {
            if (results[i] != Integer.MAX_VALUE) {

                if (distance >= (results[i] * 2)) {
                    distance -= results[i] * 2;
                } else {
                    distance = limit;
                    day++;
                    distance -= results[i] * 2;

                    if (distance < 0) {
                        System.out.println(-1);
                        return;
                    }
                }


            }
        }

        System.out.println(day);


    }


}
