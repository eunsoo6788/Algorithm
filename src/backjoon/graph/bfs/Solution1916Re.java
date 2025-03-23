package backjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1916Re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시 수 (노드 수)
        int nodeNum = Integer.parseInt(br.readLine());
        // 버스 수 (간선 수)
        int edgeNum = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for (int i = 0; i <= nodeNum; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, value));
        }


        st = new StringTokenizer(br.readLine(), " ");
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        System.out.println(bfs(nodeNum, startNode, endNode, list));


    }

    private static int bfs(int nodeNum, int start, int end, ArrayList<ArrayList<Node>> list) {

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        int[] dist = new int[nodeNum + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            int currentNode = poll.node;
            int currentCost = poll.cost;


            if (currentCost > dist[currentNode]) {
                continue;
            }


            for (Node neighbor : list.get(currentNode)) {
                int nextNode = neighbor.node;
                int nextCost = neighbor.cost;

                if (dist[nextNode] > dist[currentNode] + nextCost) {
                    dist[nextNode] = dist[currentNode] + nextCost;
                    queue.add(new Node(nextNode, dist[nextNode]));
                }


            }


        }

        return dist[end];
    }


    private static class Node implements Comparable<Node> {
        private int node;
        private int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

}
