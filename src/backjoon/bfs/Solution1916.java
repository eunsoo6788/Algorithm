package backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시 수 (노드 수)
        int nodeNum = Integer.parseInt(br.readLine());
        // 버스 수 (간선 수)
        int edgeNum = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= nodeNum; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 데이터 입력
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(startNode).add(new Node(endNode, cost));
        }

        // 시작점과 도착점 입력
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘 실행
        int result = dijkstra(nodeNum, graph, start, end);

        // 결과 출력
        System.out.println(result);
    }

    // 다익스트라 알고리즘
    private static int dijkstra(int nodeNum, ArrayList<ArrayList<Node>> graph, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[nodeNum + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;
            int currentCost = current.cost;

            // 이미 처리된 노드인 경우 스킵
            if (currentCost > dist[currentNode]) continue;

            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.node;
                int nextCost = neighbor.cost;

                if (dist[nextNode] > dist[currentNode] + nextCost) {
                    dist[nextNode] = dist[currentNode] + nextCost;
                    pq.add(new Node(nextNode, dist[nextNode]));
                }
            }
        }

        return dist[end];
    }

    // Node 클래스
    private static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
