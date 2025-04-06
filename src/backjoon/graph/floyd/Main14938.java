package backjoon.graph.floyd;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main14938 {

    /**
     * 서강그라운드
     * 골드4
     * 알고리즘 : 플로이드 워셜
     */

    private static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int boundary = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());


        int[] map = new int[nodeNum+1];
        List<Node>[] lists = new List[nodeNum+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodeNum; i++) {
            lists[i] = new ArrayList<>();
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end, weight));
            lists[end].add(new Node(start, weight));
        }

        int max = 0;
        for (int i = 1; i <= nodeNum; i++) {

            boolean[] visited = new boolean[nodeNum+1];
            int[] result = new int[nodeNum+1];

            Arrays.fill(result, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
            pq.add(new Node(i, 0));
            result[i] = 0;

            while (!pq.isEmpty()) {

                Node node = pq.poll();

                if (visited[node.end]) {
                    continue;
                }

                visited[node.end] = true;

                for (Node next : lists[node.end]) {
                    if (node.weight + next.weight < result[next.end]) {
                        result[next.end] = node.weight + next.weight;
                        pq.add(new Node(next.end, result[next.end]));
                    }
                }
            }

            int point = 0;
            for (int j = 1; j <= nodeNum; j++) {
                if (result[j] <= boundary) {
                    point += map[j];
                }
            }

            max = Math.max(max, point);


        }


        System.out.println(max);



    }


}
